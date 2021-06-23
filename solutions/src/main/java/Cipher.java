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
