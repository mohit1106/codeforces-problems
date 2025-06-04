// https://codeforces.com/contest/43/problem/B

import java.util.*;
public class letter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String heading = sc.nextLine();
        String text = sc.nextLine();
        
        int n = heading.length();
        
        Map<Character, Integer> freq1 = new HashMap<>();
        for(char c : heading.toCharArray()){
            if(c != ' '){
                freq1.put(c, freq1.getOrDefault(c, 0) + 1);
            }
        }

        Map<Character, Integer> freq2 = new HashMap<>();
        for(char c : text.toCharArray()){
            if(c != ' '){
                freq2.put(c, freq2.getOrDefault(c, 0)+1);
            }
        }
        boolean all = true;
        for(char c : text.toCharArray()){
            if(c != ' '){
                if(!(freq1.containsKey(c) && freq2.get(c) <= freq1.get(c))){
                    all = false;
                    break;
                }
            }
        }

        System.out.println(all ? "YES" : "NO");
    }
}