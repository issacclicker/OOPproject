package tensor;

import java.math.BigDecimal;

public class ScalarImpl implements Scalar,Cloneable {
    //스칼라의 자료구조
    BigDecimal scalarValue = null;

    //1. String 값 지정하는 생성자
    ScalarImpl(String value)
    {
        //스칼라 생성
    }

    //2. i이상 j미안의 무작위 값 요소로 생성
    ScalarImpl(int i,int j)
    {
        //스칼라 생성
    }

    //17s 객체 복제(Impl에서 override)
    public Scalar cloneSelf()
    {
        return clone();
    }
    @Override
    protected Scalar clone()
    {
        return null;
    }

    //24 전달 받은 두 스칼라의 덧셈
    static Scalar addScalarEach(Scalar A,Scalar B)
    {
        //구현 필요
        return null;
    }

    //25 전달 받은 두 스칼라의 곱셈
    static Scalar multiplyScalarEach(Scalar A,Scalar B)
    {
        //구현 필요
        return null;
    }
}
