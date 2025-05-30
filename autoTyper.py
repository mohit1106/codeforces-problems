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
import java.util.*;

public class MakeArrayEqual {

    // Function to compute minimum operations
    public static int minOperations(List<Integer> A) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int num : A) {
            int steps = 0;
            while (num > 0) {
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(steps);
                num /= 2;
                steps++;
            }
        }

        int minOps = Integer.MAX_VALUE;
        int n = A.size();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> opsList = entry.getValue();
            if (opsList.size() < n) continue; // Not all elements can reach this value
            Collections.sort(opsList);
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += opsList.get(i);
            }
            minOps = Math.min(minOps, total);
        }

        return minOps;
    }

    // Main method to run sample test cases
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(3, 1, 1, 3);
        List<Integer> input2 = Arrays.asList(2, 2, 2);

        System.out.println("Output 1: " + minOperations(input1)); // Expected: 2
        System.out.println("Output 2: " + minOperations(input2)); // Expected: 0
    }
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
