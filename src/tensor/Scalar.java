package tensor;

public interface Scalar {
    //12. 스칼라의 값 지정
    void setScalar(String value);

    //12. 스칼라의 값 조회
    String getScalar();
    
    //14s. 스칼라 객체 콘솔에 출력
    @Override
    String toString();

    //15s. 객체의 동등성 판단
    boolean equals(Scalar A,Scalar B);

    //16 스칼라의 값 대 소 비교
    boolean valueCompare(Scalar A,Scalar B);

    //17s 객체 복제
    void clone(Scalar A,Scalar B);

    //18 다른 스칼라와 덧셈
    void addScalar(Scalar val);

    //19 다른 스칼라와 곱셈
    void multiplyScalar(Scalar val);

    //24 전달 받은 두 스칼라의 덧셈
    Scalar addScalarEach(Scalar A,Scalar B);

    //25 전달 받은 두 스칼라의 곱셈
    Scalar multiplyScalarEach(Scalar A,Scalar B);

}
