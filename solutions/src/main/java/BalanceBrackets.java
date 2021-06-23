import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// Add any extra import statements you may need here


class BalanceBrackets {
    // Add any helper functions you may need here

    //{{[[(())]]}}
    boolean isBalanced(String s) {

        Map<Character, Character> m = new HashMap<>();
        m.put('}','{');
        m.put(']','[');
        m.put(')','(');

        // Write your code here
        if(s ==null || s.length()==0) {
            return true;
        }

        if(s.length()%2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char c: charArray) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if(m.get(c) == null) {
                stack.push(c);
            } else if (stack.peek() == m.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        String s_3 = ")";
        boolean expected_3 = false;
        boolean output_3 = isBalanced(s_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}