package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int key = scanner.nextInt();

        int c = 0;
        int y = 0;

        str = str.toLowerCase();
        StringBuilder decryptedStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                decryptedStr.append(' ');
                continue;
            }
            c = (str.charAt(i) + key);
            y = (c - 97) %26 + 97;
            decryptedStr.append((char) y);
        }

        System.out.println(decryptedStr);
    }
}
