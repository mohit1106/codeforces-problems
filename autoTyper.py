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
int res = 0;
        Arrays.sort(arr);

        // Iterate through the array, fixing the largest side at arr[i]
        for (int i = 2; i < arr.length; ++i) {
            // Initialize pointers for the two smaller sides
            int left = 0, right = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // arr[left] + arr[right] satisfies the triangle inequality,
                    // so all pairs (x, right) with (left <= x < right) are valid
                    res += right - left;

                    // Move the right pointer to check smaller pairs
                    right--;
                } else {
                    // Move the left pointer to increase the sum
                    left++;
                }
            }
        }

        return res;

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
