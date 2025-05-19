package tensor;

public interface Vector extends Scalar {
    //11v. 특정 위치의 요소를 지정
    void setVectorAt(Scalar val,int index);

    //11v. 특정 위치의 요소를 조회
    Scalar getVectorAt(int index);

    //14v. 객체 콘솔에 출력
    @Override
    String toString();

    //15v. 객체의 동등성 판단
    @Override
    boolean equals(Object o);

    //17s 객체 복제(Impl에서 override)
    Vector cloneSelf();

    //20 다른 벡터와 덧셈
    void addVector(Vector val);

    //21 다른 스칼라와 곱셈
    @Override
    void multiplyScalar(Scalar val);

    //30 n-차원 벡터 객체를 자신으로 부터 n*1 행렬을 생성하여 반환
    Matrix getRow(int index);

    //30 n-차원 벡터 객체를 자신으로 부터 1*n 행렬을 생성하여 반환
    Matrix getColumn(int index);

}
