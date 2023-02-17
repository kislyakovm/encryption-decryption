package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static String mode = "enc";
    static int key = 0;
    static String data = "";
    static boolean isFile = false;
    static String in = "";
    static String out = "";
    static String result = "";

    public static void main(String[] args) throws FileNotFoundException {

        defineAttributes(args);

        if (isFile) {
            readFromFile();
            chooseEncOrDec();
            writeToFile();
        } else {
            chooseEncOrDec();
            System.out.println(result);
        }
    }

    public static void chooseEncOrDec() {
        if ("enc".equals(mode)) {
            result = encrypting(data, key);
        } else if ("dec".equals(mode)) {
            result = decrypting(data, key);
        }
    }

    public static void readFromFile() throws FileNotFoundException {
        File file = new File(in);
        Scanner scanner = new Scanner(file);

        data = scanner.nextLine();
        scanner.close();
    }

    public static void writeToFile(){
        File file = new File(out);

        try (PrintWriter pw = new PrintWriter(file)){
            pw.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void defineAttributes(String[] args) {
        for (int i = 0; i < args.length; i += 2) {

            switch (args[i]) {
                case "-mode" -> mode = args[i + 1];
                case "-key" -> key = Integer.parseInt(args[i + 1]);
                case "-data" -> data = args[i + 1];
                case "-in" -> {
                    in = args[i + 1];
                    isFile = true;
                }
                case "-out" -> {
                    out = args[i + 1];
                    isFile = true;
                }
            }
        }
    }

    public static String encrypting(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character + key);
            result.append(newCharacter);
        }
        return String.valueOf(result);
    }

    public static String decrypting(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character - key);
            result.append(newCharacter);
        }
        return String.valueOf(result);
    }
}
