import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BigInteger secret1 = findSecret("testcase1.json");
        BigInteger secret2 = findSecret("testcase2.json");
        System.out.println("Secret for testcase1: " + secret1);
        System.out.println("Secret for testcase2: " + secret2);
    }

    /**
     * Computes the secret (constant term c) from a JSON file containing polynomial roots.
     * @param jsonFile Path to the JSON file
     * @return The secret as a BigInteger
     * @throws Exception If file reading or parsing fails
     */
    public static BigInteger findSecret(String jsonFile) throws Exception {
        // Step 1: Read and parse the JSON file
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(new File(jsonFile), Map.class);
        Map<String, String> keys = (Map<String, String>) jsonMap.get("keys");
        int n = Integer.parseInt(keys.get("n"));
        int k = Integer.parseInt(keys.get("k"));

        // Step 2: Collect and decode points
        List<Point> points = new ArrayList<>();
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals("keys")) continue;
            BigInteger x = new BigInteger(key);
            Map<String, String> valueMap = (Map<String, String>) entry.getValue();
            int base = Integer.parseInt(valueMap.get("base"));
            String value = valueMap.get("value");
            BigInteger y = new BigInteger(value, base);
            points.add(new Point(x, y));
        }

        // Sort points by x for consistency
        Collections.sort(points, Comparator.comparing(p -> p.x));

        // Take first k points
        List<Point> selectedPoints = points.subList(0, k);

        // Step 3: Compute Lagrange interpolation for P(0)
        BigDecimal sum = BigDecimal.ZERO;
        MathContext mc = new MathContext(100); // High precision for 256-bit numbers
        for (int i = 0; i < k; i++) {
            Point pi = selectedPoints.get(i);
            BigDecimal product = BigDecimal.ONE;
            for (int j = 0; j < k; j++) {
                if (i == j) continue;
                Point pj = selectedPoints.get(j);
                BigDecimal negXj = new BigDecimal(pj.x.negate());
                BigDecimal xiMinusXj = new BigDecimal(pi.x.subtract(pj.x));
                BigDecimal term = negXj.divide(xiMinusXj, mc);
                product = product.multiply(term, mc);
            }
            BigDecimal yi = new BigDecimal(pi.y);
            sum = sum.add(yi.multiply(product, mc), mc);
        }

        // Round to the nearest integer to get the secret c
        return sum.setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();
    }

    /**
     * Represents a point (x, y) on the polynomial.
     */
    static class Point {
        BigInteger x;
        BigInteger y;

        Point(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }
}