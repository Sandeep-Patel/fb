/**
 * Pair Sums
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
 *
 * Signature
 * int numberOfWays(int[] arr, int k)
 *
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000,000,000].
 * k is in the range [1, 1,000,000,000].
 *
 * Output
 * Return the number of different pairs of elements which sum to k.
 *
 * Example 1
 * n = 5
 * k = 6
 * arr = [1, 2, 3, 4, 3]
 * output = 2
 * The valid pairs are 2+4 and 3+3.
 *
 * Example 2
 * n = 5
 * k = 6
 * arr = [1, 5, 3, 3, 3]
 * output = 4
 * There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// Add any extra import statements you may need here


class PairSums {

    // Add any helper functions you may need here

    int numberOfWays(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        // Write your code here
        int output = 0;
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int mapValue = map.get(arr[i]) == null ? 0 : map.get(arr[i]);
            map.put(arr[i], mapValue + 1);
        }

        for (int key:  map.keySet()) {
            int nwe = k-key;
            Integer minusVal = map.get(nwe);
            if(minusVal != null) {
                if(nwe == key) {
                    output += minusVal * (minusVal - 1);
                } else {
                    output += minusVal * map.get(key);
                }
            }
        }
        return output/2;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
       int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        int k_3 = 6;
        int[] arr_3 = {1, 5, 3, 3, 3, 5, 3};
        int expected_3 = 8;
        int output_3 = numberOfWays(arr_3, k_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSums().run();
    }
}
