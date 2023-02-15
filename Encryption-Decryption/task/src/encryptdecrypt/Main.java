package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        String str = scanner.nextLine();
        int key = scanner.nextInt();

        if ("enc".equals(operation)) {
            encrypting(str, key);
        } else if ("dec".equals(operation)) {
            decrypting(str, key);
        }
    }

    public static void encrypting(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character + key);
            result.append(newCharacter);
        }
        System.out.println(result);
    }


    public static void decrypting(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character - key);
            result.append(newCharacter);
        }
        System.out.println(result);
    }
}
