import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class QueueRemoval {

    // Add any helper functions you may need here
    class Position {
        int index;
        int val;
        Position(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here
        int[] output = new int[x];
        Queue<Position> positions = new LinkedList<>();

        // Build Queue
        for (int i = 0; i < arr.length; i++) {
            positions.add(new Position(i + 1, arr[i]));
        }

        // Iterations
        List<Position> popped;
        int pass = 0;
        for (int i = 0; i < x; i++) {
            // Step 1. Pop x elements
            popped = new ArrayList<>();
            for (int j = 0; j < x && !positions.isEmpty(); j++) {
                popped.add(positions.poll());
            }

            // Step 2. Remove Largest element
            int max = 0;
            int maxIdx = Integer.MAX_VALUE;
            for (Position p: popped) {
                if (p.val == max) {
                    maxIdx = Math.min(maxIdx, p.index);
                } else if (p.val > max) {
                    max = p.val;
                    maxIdx = p.index;
                }
            }
            output[pass++] = maxIdx;

            // Step 3. Decrement Values & Add Back
            for (Position p: popped) {
                if (p.index != maxIdx) { // remove from queue
                    Position next = new Position(p.index, (p.val == 0) ? p.val : p.val - 1);
                    positions.add(next);
                }
            }
        }

        return output;
    }





    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new QueueRemoval().run();
    }
}
