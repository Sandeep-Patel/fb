public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
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

        int[] arr_1 = {1, 2, 3, 3, 4};
        int expected_1 = 4;
        int output_1 = removeDuplicates(arr_1);
        check(expected_1, output_1);


        int[] arr_2 = {1, 1};
        int expected_2 = 1;
        int output_2 = removeDuplicates(arr_2);
        check(expected_2, output_2);



        // Add your own test cases here

    }
    public static void main(String[] args) {
        new RemoveDuplicate().run();
    }
}
