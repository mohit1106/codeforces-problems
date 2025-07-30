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
