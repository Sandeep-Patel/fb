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
    public static void main(String[] args) {
        int rotationFactor = 39;
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";

        String cipheredText = new Cipher().rotationalCipher(input, rotationFactor);
        System.out.println(cipheredText);
    }

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
}
