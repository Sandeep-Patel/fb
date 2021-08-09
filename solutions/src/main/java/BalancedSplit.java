import java.util.Arrays;

public class BalancedSplit {


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    public static void main(String[] args) {
        new BalancedSplit().run();
    }

    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        int totalRight = 0;
        int totalLeft = 0;

        Arrays.sort(arr);
        for (int i=arr.length-1,j=0; j<i; i--) {
            System.out.print(arr[i] + " ");
            int prev1 = arr[i];
            while(prev1 == arr[j]) {
                totalRight += arr[i];
            }
            int prev = arr[j];
            while(prev == arr[j] || totalLeft< totalRight && j<i) {
                totalLeft += arr[j];
                j++;
            }
        }





        return totalLeft == totalRight;


    }

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
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
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
}

