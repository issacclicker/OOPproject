package tensor;

public class VectorDimensionCannotBeZero extends RuntimeException {
    public VectorDimensionCannotBeZero(String message) {
        super(message);
    }
}
