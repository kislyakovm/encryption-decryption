package encryptdecrypt;

public class ShiftFactory implements AlgorithmFactory{
    @Override
    public Algorithm createAlgorithm() {
        return new Shift();
    }
}
