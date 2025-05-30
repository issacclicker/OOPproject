package tensor;

public class DimensionCannotBeZero extends RuntimeException {
    public DimensionCannotBeZero(String message) {
        super(message);
    }
}
