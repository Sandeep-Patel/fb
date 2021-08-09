import java.util.Arrays;
// Add any extra import statements you may need here


public class ChangeForeignCurrency {

    // Add any helper functions you may need here


    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        Arrays.sort(denominations);
        for(int i=denominations.length-1; i>0; i--) {
            if (targetMoney % denominations[i] == 0) {
                return true;
            } else {
                targetMoney = targetMoney % denominations[i];
            }
        }

        return false;
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
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        int target_4 = 999999;
        int arr_4[] = {54,52,50,48,46,44,42,40,38,36,34,32,30,28,26,24,22,20,18,16,14,12,10,8,6,4,2};
        boolean expected_4 = false;
        boolean output_4 = canGetExactChange(target_4, arr_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ChangeForeignCurrency().run();
    }
}