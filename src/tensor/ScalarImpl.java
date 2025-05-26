package tensor;

import java.math.BigDecimal;

class ScalarImpl implements Scalar,Cloneable {
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

    //12. 스칼라의 값 지정
    public void setScalar(String value)
    {
        System.out.println("[val]로 값 지정");
    }

    //12. 스칼라의 값 조회
    public String getScalar()
    {
        String result = "TEST";
        System.out.println("스칼라 값 얻음");
        return result;
    }

    //14s. 스칼라 객체 콘솔에 출력
    @Override
    public String toString()
    {
        String result = "TEST";
        return result;
    }

    //15s. 객체의 동등성 판단
    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        return false;
    }

    //16 스칼라의 값 대 소 비교
    public boolean valueCompare(Scalar A,Scalar B)
    {
        boolean result = false;
        return false;
    }

    //17s 객체 복제(Impl에서 override)
    public Scalar cloneSelf()
    {
        return clone();
    }
    @Override
    protected Scalar clone()
    {
        Scalar result = null;
        System.out.println("객체 복제됨");
        return result;
    }

    //18 다른 스칼라와 덧셈
    public void addScalar(Scalar val)
    {
        System.out.println("[val] 더해짐");
    }

    //19 다른 스칼라와 곱셈
    public void multiplyScalar(Scalar val)
    {
        System.out.println("[val] 곱해짐");
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
