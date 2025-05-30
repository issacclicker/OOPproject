package tensor;
import java.io.File;

public class Factory {
    //스칼라 생성
    public static Scalar getScalar(String value)
    { //스칼라 값 지정 후 생성
        return new ScalarImpl(value);
    }

    public static Scalar getScalar(int i, int j)
    { //스칼라 값 랜덤 생성
        return new ScalarImpl(i,j);
    }
    //벡터 생성
    public static Vector getVector(Scalar val, int n)
    {
        return new VectorImpl(val,n);
    }

    public static Vector getVector(int i,int j, int n)
    {
        return new VectorImpl(i,j,n);
    }

    public static Vector getVector(int[] arr)
    {
        return new VectorImpl(arr);
    }

    //행렬 생성
    public static Matrix getMatrix(Scalar val, int m, int n)
    {
        return new MatrixImpl(val,m,n);
    }

    public static Matrix getMatrix(int i, int j, int m, int n)
    {
        return new MatrixImpl(i,j,m,n);
    }

    public static Matrix getMatrix(File val, int m, int n)
    {
        return new MatrixImpl(val,m,n);
    }

    public static Matrix getMatrix(int[][] arr, int m, int n)
    {
        return new MatrixImpl(arr,m,n);
    }

    public static Matrix getMatrix(int n)
    {
        return new MatrixImpl(n);
    }
}
