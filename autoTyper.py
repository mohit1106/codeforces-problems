import pyautogui
import time
import keyboard
import threading

pyautogui.FAILSAFE = False

# Function to simulate human-like typing line by line
def auto_typer(text, delay=0.05):
    for line in text.strip().split('\n'):
        pyautogui.write(line)
        pyautogui.press('enter')
        time.sleep(delay)

# Wrapper to delay and start typing
def start_typing(snippet, delay=0.05):
    print("Typing will start in 3 seconds... Switch to your editor now!")
    time.sleep(3)
    print("Typing started.")
    auto_typer(snippet, delay)
    print("Typing finished.")

# Code snippets
cplusplus_code = '''
class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Process both strings to handle sign and leading zeros
        s1 = process(s1);
        s2 = process(s2);
        
        // Handle edge case when either number is zero
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        // Determine if the result will be negative
        int sign = 1;
        if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
            sign = -1;
        }
        if (s1.charAt(0) != '-' && s2.charAt(0) == '-') {
            sign = -1;
        }
        
        // Remove the sign for the multiplication process
        if (s1.charAt(0) == '-') s1 = s1.substring(1);
        if (s2.charAt(0) == '-') s2 = s2.substring(1);
        
        // Now multiply the two strings
        int m = s1.length();
        int n = s2.length();
        int[] result = new int[m + n]; // result array to store the product

        // Perform multiplication of each digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add previous carry
                result[i + j + 1] = sum % 10; // Store the current digit
                result[i + j] += sum / 10; // Carry for the next digit
            }
        }
        
        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        // If the result should be negative, add the minus sign
        if (sign == -1) {
            sb.insert(0, '-');
        }
        
        return sb.toString();
    }

    // Helper method to process the strings by removing leading zeros and handling sign
    private String process(String s) {
        int index = 0;
        // Skip any leading zeroes
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        
        // If the entire string is zeros, return "0"
        if (index == s.length()) {
            return "0";
        }
        
        // Return the substring without leading zeros
        return s.substring(index);
    }
}


'''

hello_world_code = '''
#include <iostream>
using namespace std;

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}
'''

# Start background hotkeys
def main():
    print("=== Auto Typer Started ===")
    print("Press ALT+Q to type C++ function.")
    print("Press ALT+N to type Hello World.")
    print("Press ALT+. to quit.")

    keyboard.add_hotkey('alt+q', lambda: threading.Thread(target=start_typing, args=(cplusplus_code,)).start())
    keyboard.add_hotkey('alt+n', lambda: threading.Thread(target=start_typing, args=(hello_world_code,)).start())
    keyboard.add_hotkey('alt+.', lambda: exit_program())

    keyboard.wait()  # Waits forever until quit

def exit_program():
    print("Exiting program...")
    keyboard.unhook_all_hotkeys()
    exit()

if __name__ == "__main__":
    main()
