package tensor;

class VectorImpl implements Vector,Cloneable {
    //벡터의 자료구조
    java.util.Vector<Scalar> vectorValues;
    private int dimension = 0;

    //temp
    VectorImpl()
    {

    }

    //3. 지정한 하나의 값을 모든 요소의 값으로 하는 n차원 벡터 생성
    VectorImpl(Scalar val, int n)
    {

    }

    //4. i 이상 j 미만의 무작위 값을 요소로 하는 n차원 벡터 생성
    VectorImpl(int i, int j, int n)
    {

    }

    //5. 1차원 배열로부터 n-차원 벡터 생성
    VectorImpl(int[] arr)
    {

    }

    //11v. 특정 위치의 요소를 지정
    public void setAt(Scalar val,int index) {

    };

    //11v. 특정 위치의 요소를 조회
    public Scalar getAt(int index){
        Scalar result = new ScalarImpl();
        return result;
    };

    //13v. 크기 정보 조회
    public int size(){
        int result = 0;
        return result;
    };

    //14v. 객체 콘솔에 출력
    @Override
    public String toString(){
        //구현
        return "";
    }

    //15v. 객체의 동등성 판단
    @Override
    public boolean equals(Object o){
        //구현
        boolean result= true;
        return result;
    }

    //17s 객체 복제(Impl에서 override)
    public Vector cloneSelf()
    {
        return clone();
    }
    @Override
    protected Vector clone()
    {
        return new VectorImpl();
    }

    //20 다른 벡터와 덧셈
    public void addVector(Vector val){
        //구현
    }

    //21 다른 스칼라와 곱셈
    @Override
    public void multiplyScalar(Scalar val){
        //구현
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

    //31 n-차원 벡터 객체를 자신으로 부터 1*n 행렬을 생성하여 반환
    public Matrix getRow(){
        Matrix result = null;
        return result;
    }

    //30 n-차원 벡터 객체를 자신으로 부터 n*1 행렬을 생성하여 반환
    public Matrix getColumn(){
        Matrix result = null;
        return result;
    }
}
