class UserMainCode(object):
    @classmethod
    def countTriangleSubstrings(cls, input1):
        '''
        input1 : string
        Expected return type : int
        '''
        s = input1
        N = len(s)
        count = 0
        # Iterate through all possible starting positions for a 5-character substring
        for i in range(N - 4):
            # Check the triangle conditions:
            # s[i] < s[i+1] < s[i+2] > s[i+3] > s[i+4]
            if (s[i] < s[i + 1] and
                s[i + 1] < s[i + 2] and
                s[i + 2] > s[i + 3] and
                s[i + 3] > s[i + 4]):
                count += 1
        return count
    
if __name__ == "__main__":
    input_string = input().strip()  # Read input string from user and remove whitespace
    result = UserMainCode.countTriangleSubstrings(input_string)  # Call the method
    print(result)  # Print the result