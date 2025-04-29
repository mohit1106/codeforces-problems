import java.util.*;
public class main {
    public static int largestElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
    public static void main(String[] args) {
        int[] arr = {3,3,6,1};
        System.out.println(largestElement(arr));
    }
}