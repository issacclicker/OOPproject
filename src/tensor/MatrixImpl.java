package tensor;

import java.io.File;

class MatrixImpl implements Matrix {
    //행렬의 자료구조
    java.util.Vector<Vector> MatrixValues;
    private int rows;
    private int cols;

    // Matrix 인터페이스 메서드들
    public void setMatrixAt(int i, int j, Scalar val) {
        System.out.println("setMatrixAt 호출 성공");
    }

    public Scalar getMatrixAt(int i, int j) {
        System.out.println("getMatrixAt 호출 성공");
        return null;
    }

    public int size(String option) {
        System.out.println("size 호출 성공");
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals 호출 성공");
        return false;
    }

    public void addMatrix(Matrix m) {
        System.out.println("addMatrix 호출 성공");
    }

    public void multiplyMatrix(Matrix m, String multiplyDirection) {
        System.out.println("multiplyMatrix 호출 성공");
    }

    public void connectMatrix(Matrix m, String connectDirection) {
        System.out.println("connectMatrix 호출 성공");
    }

    public Vector extractMatrixToVector(int index, String extractDirection) {
        System.out.println("extractMatrixToVector 호출 성공");
        return null;
    }

    public Matrix extractSubMatrix(int beginRow, int endRow, int beginColumn, int endColumn) {
        System.out.println("extractSubMatrix(범위) 호출 성공");
        return null;
    }

    public Matrix extractSubMatrix(int exceptingRow, int exceptingColumn) {
        System.out.println("extractSubMatrix(제외) 호출 성공");
        return null;
    }

    public Matrix getTranspose() {
        System.out.println("getTranspose 호출 성공");
        return null;
    }

    public Scalar getTrace() {
        System.out.println("getTrace 호출 성공");
        return null;
    }

    public boolean isSquareMatrix() {
        System.out.println("isSquareMatrix 호출 성공");
        return false;
    }

    public boolean isUpperTriangularMatrix() {
        System.out.println("isUpperTriangularMatrix 호출 성공");
        return false;
    }

    public boolean isLowerTriangularMatrix() {
        System.out.println("isLowerTriangularMatrix 호출 성공");
        return false;
    }

    public boolean isIdentityMatrix() {
        System.out.println("isIdentityMatrix 호출 성공");
        return false;
    }

    public boolean isZeroMatrix() {
        System.out.println("isZeroMatrix 호출 성공");
        return false;
    }

    public void swapRow(int A, int B) {
        System.out.println("swapRow 호출 성공");
    }

    public void swapColumn(int A, int B) {
        System.out.println("swapColumn 호출 성공");
    }

    public void multiplyByScalar(Scalar value, String multiplyCondition) {
        System.out.println("multiplyByScalar 호출 성공");
    }

    public void addMultipliedRow(int A, int B, Scalar multiplyValue) {
        System.out.println("addMultipliedRow 호출 성공");
    }

    public void addMultipliedColumn(int A, int B, Scalar multiplyValue) {
        System.out.println("addMultipliedColumn 호출 성공");
    }

    public Matrix getRREF() {
        System.out.println("getRREF 호출 성공");
        return null;
    }

    public boolean isRREF() {
        System.out.println("isRREF 호출 성공");
        return false;
    }

    public Scalar getDeterminant() {
        System.out.println("getDeterminant 호출 성공");
        return null;
    }

    public Matrix getReversed() {
        System.out.println("getReversed 호출 성공");
        return null;
    }


    public void add(Scalar val) {
        System.out.println("Vector add 호출 성공");
    }

    public void subtract(Scalar val) {
        System.out.println("Vector subtract 호출 성공");
    }

    public void multiply(Scalar val) {
        System.out.println("Vector multiply 호출 성공");
    }

    public void divide(Scalar val) {
        System.out.println("Vector divide 호출 성공");
    }

    public int getSize() {
        System.out.println("Vector getSize 호출 성공");
        return 0;
    }

    public Scalar get(int index) {
        System.out.println("Vector get 호출 성공");
        return null;
    }

    public void set(int index, Scalar val) {
        System.out.println("Vector set 호출 성공");
    }

    @Override
    protected Matrix clone() {
        System.out.println("protected clone 호출 성공");
        return null;
    }

    // 생성자들
    //6 지정한 하나의 값을 모든 요소의 값으로 하는 m*n 행렬 생성
    MatrixImpl(Scalar val, int m, int n) {
        rows = m;
        cols = n;
        MatrixValues = new java.util.Vector<>();
    }

    //7 i 이상 j 미만의 무작위 값을 요소로 하는 m * n 행렬 생성
    MatrixImpl(int i, int j, int m, int n) {
        this.rows = m;
        this.cols = n;
    }

    //8 csv 파일로 부터 m*n 행렬 생성
    //수정 필요
    MatrixImpl(File val, int m, int n) {
        this.rows = m;
        this.cols = n;
    }

    //9 2차원 배열로부터 m*n 행렬 생성
    MatrixImpl(int[][] arr, int m, int n) {
        this.rows = m;
        this.cols = n;
    }

    //10 단위 행렬 생성
    //크기는 어떻게 되는 걸까요..?
    MatrixImpl(int n) {
        this.rows = n;
        this.cols = n;
    }

    //17s 객체 복제(Impl에서 override)
    public Matrix cloneSelf() {
        return clone();
    }

    //28 전달받은 두 행렬의 덧셈
    static Matrix addMatrixEach(Matrix A, Matrix B) {
        Matrix resultof28 = null;
        //구현 필요
        return resultof28;
    }

    //29 전달받은 두 행렬의 곱셈
    static Matrix multiplyMatrixEach(Matrix A, Matrix B) {
        Matrix resultof29 = null;
        //구현 필요
        return resultof29;
    }
}