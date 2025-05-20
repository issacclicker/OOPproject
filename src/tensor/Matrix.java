package tensor;

public interface Matrix extends Vector {
    //11m 특정 위치의 요소 지정
    void setMatrixAt(int i, int j, Scalar val);

    //11m 특정 위치의 요소 조회
    Scalar getMatrixAt(int i, int j);

    //13m 크기 정보 조회 (행 또는 열 개수 반환)
    int size(String option);

    //15m. 객체의 동등성 판단
    @Override
    boolean equals(Object o);


    //22 다른 행렬과의 덧셈
    void addMatrix(Matrix m);

    //23 다른 행렬과의 곱셈 (왼/오)
    // 기존행렬 * m -> multiplyDirection = left
    // m * 기존행렬 -> multiplyDirection = right
    void multiplyMatrix(Matrix m, String multiplyDirection);

    //32 33 다른 행렬과 가로/세로로 합치기
    void connectMatrix(Matrix m, String connectDirection);

    //34 35 행렬의 특정 행/열을 벡터 형태로 추출
    Vector extractMatrixToVector(int index,String extractDirection);

    //36 특정 범위의 부분 행렬 추출 - 인덱스
    Matrix extractSubMatrix(int beginRow, int endRow, int beginColumn, int endColumn);

    //37 특정 범위의 부분 행렬 추출 - 특정 행, 열 제외
    Matrix extractSubMatrix(int exceptingRow, int exceptingColumn);

    //38 행렬의 전치행렬을 새로 생성하여 구함
    Matrix getTranspose();

    //39 행렬의 대각 요소의 합
    Scalar getTrace();

    //40 자신이 정사각 행렬인지?
    boolean isSquareMatrix();

    //41 자신이 상삼각 행렬인지?
    boolean isUpperTriangularMatrix();

    //42 자신이 하삼각 행렬인지?
    boolean isLowerTriangularMatrix();

    //43 자신이 단위 행렬인지?
    boolean isIdentityMatrix();

    //44 자신이 영행렬인지?
    boolean isZeroMatrix();

    //45 특정 두 행의 위치를 맞교환
    void swapRow(int A,int B);

    //46 특정 두 열의 위치를 맞교환
    void swapColumn(int A,int B);

    //47 48 특정 행/열에 상수배(스칼라)
    //multiplyCondition -> 행에 곱할건지, 열에 곱할건지
    void multiplyByScalar(Scalar value, String multiplyCondition);

    //49 특정 행에 다른 행의 상수배를 더할 수 있다.
    void addMultipliedRow(int A,int B,Scalar multiplyValue);

    //50 특정 열에 다른 열의 상수배를 더할 수 있다.
    void addMultipliedColumn(int A,int B,Scalar multiplyValue);

    //51 RREF 행렬 반환
    Matrix getRREF();

    //52 RREF 여부
    boolean isRREF();

    //53 행렬식 구하기
    //리턴 이거 맞는지 모르겠다
    Scalar getDeterminant();

    //54 역행렬 구하기
    Matrix getReversed();
}
