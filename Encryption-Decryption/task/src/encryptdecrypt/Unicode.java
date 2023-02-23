package encryptdecrypt;

public class Unicode implements Algorithm {
    @Override
    public String encrypt(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character + key);
            result.append(newCharacter);
        }
        return String.valueOf(result);
    }

    @Override
    public String decrypt(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : str.toCharArray()) {
            char newCharacter = (char) (character - key);
            result.append(newCharacter);
        }
        return String.valueOf(result);
    }
}
