package tensor;

public class VectorImpl implements Vector,Cloneable {
    //벡터의 자료구조
    java.util.Vector<Scalar> vectorValues;

    //3. 지정한 하나의 값을 몯느 요소의 값으로 하는 n차원 벡터 생성
    VectorImpl(Scalar val, int n)
    {

    }

    //4. i 이상 j 미만의 무작위 값을 요소로 하는 n차원 벡터 생성
    VectorImpl(int i, int j, int n)
    {

    }

    //5. 1차원 배열로부터 n-차원 벡터 생성
    VectorImpl(int[] arr, int n)
    {

    }

    //17s 객체 복제(Impl에서 override)
    public Vector cloneSelf()
    {
        return clone();
    }
    @Override
    protected Vector clone()
    {
        return null;
    }


    //26 전달 받은 두 벡터의 덧셈
    static Vector addVectorEach(Vector A,Vector B)
    {
        //구현 필요
        return null;
    }
    //27 전달 받은 스칼라와 벡터의 곱셈
    static Vector multiplyVectorScalar(Vector A,Scalar B)
    {
        //구현 필요
        return null;
    }
}
