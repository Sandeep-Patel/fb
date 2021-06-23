/***
 * Rotational Cipher
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 *
 * Signature
 * string rotationalCipher(string input, int rotationFactor)
 *
 * Input
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 *
 * Output
 * Return the result of rotating input a number of times equal to rotationFactor.
 *
 * Example 1
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 *
 * Example 2
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class Cipher {

    private static char rotateCharacter(char c, int rotationFactor) {
        if (c > 96 && c < 123) {
            return (char) (((c - 'a' + rotationFactor) % 26) + 'a');
        }
        return (char) (((c - 'A' + rotationFactor) % 26) + 'A');
    }

    private static char rotateNumber(char c, int rotationFactor) {
        return (char) (((c - '0' + rotationFactor) % 10) + '0');
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        System.out.println(rotationFactor);
        int rotationFactorA = rotationFactor % 26;
        int rotationFactorN = rotationFactor % 10;
        //System.out.println(rotationFactorA);
        //System.out.println(rotationFactorN);
        char[] s = input.toCharArray();
        char[] o = new char[input.length()];
        int count = 0;
        for (char a : s) {
            char cipherredChar = 0;
            if (Character.isDigit(a)) {
                cipherredChar = rotateNumber(a, rotationFactorN);
            } else if (Character.isAlphabetic(a)) {
                cipherredChar = rotateCharacter(a, rotationFactorA);
            } else {
                cipherredChar = a;
            }
            //System.out.println(cipherredChar);
            o[count++] = (char) cipherredChar;
        }

        return new String(o);

    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
            System.out.print(rightTick + " Expected: ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();

        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Cipher().run();
    }

    /*public static void main(String[] args) {
        int rotationFactor = 39;
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";

        String cipheredText = new Cipher().rotationalCipher(input, rotationFactor);
        System.out.println(cipheredText);
    }*/
}
