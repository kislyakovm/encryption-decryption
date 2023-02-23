package encryptdecrypt;

public class UnicodeFactory implements AlgorithmFactory{
    @Override
    public Algorithm createAlgorithm() {
        return new Unicode();
    }
}
