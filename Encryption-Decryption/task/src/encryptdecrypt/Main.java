package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        int key;
        String operation;
        String str;

        if ("-key".equals(args[0])) {
            key = Integer.parseInt(args[1]);
            if ("-mode".equals(args[2])) {
                operation = args[3];
                str = args[5];
            } else {
                operation = args[5];
                str = args[3];
            }
        } else if ("-key".equals(args[2])) {
            key = Integer.parseInt(args[3]);
            if ("-mode".equals(args[0])) {
                operation = args[1];
                str = args[5];
            } else {
                operation = args[5];
                str = args[1];
            }
        } else {
            key = Integer.parseInt(args[5]);
            operation = args[1];
            str = args[3];
        }

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
