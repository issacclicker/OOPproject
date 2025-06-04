package tensor;

import java.math.BigDecimal;
import java.util.Random;

class ScalarImpl implements Scalar,Cloneable,Comparable<Scalar> {
    //스칼라의 자료구조
    BigDecimal scalarValue = null;

    //temp
    ScalarImpl()
    {

    }

    //1. String 값 지정하는 생성자
    ScalarImpl(String value)
    {
        scalarValue = BigDecimal.valueOf(Double.parseDouble(value));
    }

    //2. i이상 j미안의 무작위 값 요소로 생성
    ScalarImpl(int i,int j)
    {
        Random rand = new Random();
        scalarValue = BigDecimal.valueOf(rand.nextInt(i,j+1));
    }

    //12. 스칼라의 값 지정
    public void setScalar(String value)
    {
        scalarValue = BigDecimal.valueOf(Double.parseDouble(value));
    }

    //12. 스칼라의 값 조회
    public String getScalar()
    {
        return scalarValue.toString();
    }

    //14s. 스칼라 객체 콘솔에 출력
    @Override
    public String toString()
    {
        return scalarValue.toString();
    }

    //15s. 객체의 동등성 판단
    @Override
    public boolean equals(Object o)
    {
        if(this.toString().equals(((Scalar)o).getScalar()))
        {
            return true;
        }
        return false;
    }

    //16 스칼라의 값 대 소 비교
    public int compareWith(Scalar A)
    {
        return compareTo(A);
    }

    @Override
    public int compareTo(Scalar A)
    {
        BigDecimal comparingValue = BigDecimal.valueOf(Double.parseDouble(A.getScalar()));

        return scalarValue.compareTo(comparingValue);
    }

    //17s 객체 복제(Impl에서 override)
    public Scalar cloneSelf()
    {
        return clone();
    }
    @Override
    protected Scalar clone()
    {
        return new ScalarImpl(scalarValue.toString());
    }

    //18 다른 스칼라와 덧셈
    public void addScalar(Scalar val)
    {
        scalarValue = BigDecimal.valueOf(Double.parseDouble(this.getScalar()) + Double.parseDouble(val.getScalar()));
    }

    //19 다른 스칼라와 곱셈
    public void multiplyScalar(Scalar val)
    {
        scalarValue = BigDecimal.valueOf(Double.parseDouble(this.getScalar()) * Double.parseDouble(val.getScalar()));
    }

    //24 전달 받은 두 스칼라의 덧셈
    static Scalar addScalarEach(Scalar A,Scalar B)
    {
        return new ScalarImpl(String.valueOf(Double.parseDouble(A.getScalar()) + Double.parseDouble(B.getScalar())));
    }

    //25 전달 받은 두 스칼라의 곱셈
    static Scalar multiplyScalarEach(Scalar A,Scalar B)
    {
        return new ScalarImpl(String.valueOf(Double.parseDouble(A.getScalar()) * Double.parseDouble(B.getScalar())));
    }
}
