package encryptdecrypt;

public class Shift implements Algorithm {
    @Override
    public String encrypt(String str, int key) {
        int c;
        int y;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                if (Character.isUpperCase(str.charAt(i))) {
                    c = (str.charAt(i) + key);
                    y = (c - 'A') % 26 + 'A';
                    result.append((char) y);
                } else {
                    c = (str.charAt(i) + key);
                    y = (c - 'a') % 26 + 'a';
                    result.append((char) y);
                }
            } else {
                result.append(str.charAt(i));
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String decrypt(String str, int key) {
        int c;
        int y;
//        key = 26 - (key % 26);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                if (Character.isUpperCase(str.charAt(i))) {
                    c = (str.charAt(i) - 'A');
                    y = (c + 26 - (key % 26)) % 26 + 'A';
                    result.append((char) y);
                } else {
                    c = (str.charAt(i) - 'a');
                    y = (c + 26 - (key % 26)) % 26 + 'a';
                    result.append((char) y);
                }
            } else {
                result.append(str.charAt(i));
            }
        }
        return String.valueOf(result);
    }
}
