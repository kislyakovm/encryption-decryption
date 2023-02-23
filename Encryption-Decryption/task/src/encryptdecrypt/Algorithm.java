package encryptdecrypt;

public interface Algorithm {
    String encrypt(String str, int key);
    String decrypt(String str, int key);
}
