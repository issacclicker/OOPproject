package tensor;

public class Tensors {
    //스칼라 연산
    public static Scalar addScalarEach(Scalar A, Scalar B) { return ScalarImpl.addScalarEach(A, B); }

    public static Scalar multiplyScalarEach(Scalar A, Scalar B)
    {
        return ScalarImpl.multiplyScalarEach(A, B);
    }

    //벡터 연산
    public static Vector addVectorEach(Vector A, Vector B)
    {
        return VectorImpl.addVectorEach(A, B);
    }

    public static Vector multiplyVectorScalar(Vector A, Scalar B)
    {
        return VectorImpl.multiplyVectorScalar(A, B);
    }

    //행렬 연산
    public static Matrix addMatrixEach(Matrix A, Matrix B)
    {
        return MatrixImpl.addMatrixEach(A, B);
    }

    public static Matrix multiplyMatrixEach(Matrix A, Matrix B)
    {
        return MatrixImpl.multiplyMatrixEach(A, B);
    }
}
