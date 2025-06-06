package tensor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class MatrixImpl implements Matrix {
    //행렬의 자료구조
    java.util.Vector<Vector> MatrixValues;
    private int rows;
    private int cols;


    // Matrix 인터페이스 메서드들
    //11m
    public void setMatrixAt(int i, int j, Scalar val)
    {
        MatrixValues.get(i).setAt(val,j);
    }

    public Scalar getMatrixAt(int i, int j) {
        return MatrixValues.get(i).getAt(j);
    }

    //13m
    public int size(String option) {
        if(option.equals("row"))
        {
            return rows;
        }
        else
        {
            return cols;
        }
    }

    //14m
    public String toString()
    {
        String result = "";

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result += MatrixValues.get(i).getAt(j) + " ";
            }
            if(i<rows-1)
            {
                result += "\n";
            }
        }

        return result;
    }

    //15m
    @Override
    public boolean equals(Object o) {
        if(o.toString().equals(this.toString())) return true;
        else return false;
    }

    //22
    public void addMatrix(Matrix m)
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                setMatrixAt(i,j,Tensors.addScalarEach(this.getMatrixAt(i,j),m.getMatrixAt(i,j)));
            }
        }
    }

    //23
    public void multiplyMatrix(Matrix m, String multiplyDirection)
    {
        //m * 기존행렬
        if(multiplyDirection.equals("right"))
        {
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<cols;j++)
                {
                    Scalar sum = Factory.getScalar("0");
                    for(int k=0;k<rows;k++)
                    {
                        sum.addScalar(Tensors.multiplyScalarEach(this.getMatrixAt(k,j),m.getMatrixAt(i,k)));
                    }
                    this.setMatrixAt(i,j,sum);
                }
            }
        }
        else
        {
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<cols;j++)
                {
                    Scalar sum = Factory.getScalar("0");
                    for(int k=0;k<rows;k++)
                    {
                        sum.addScalar(Tensors.multiplyScalarEach(m.getMatrixAt(k,j),this.getMatrixAt(i,k)));
                    }
                    this.setMatrixAt(i,j,sum);
                }
            }
        }
    }

    //32,33
    public void connectMatrix(Matrix m, String connectDirection)
    {

        if(connectDirection.equals("horizontal"))
        {
            cols += m.size("cols");

            for(int i=0;i<m.size("row");i++)
            {
                for(int j=0;j<m.size("cols");j++)
                {
                    ((VectorImpl)this.MatrixValues.get(i)).expansion(m.getMatrixAt(i,j));
                }
            }
        }
        else
        {
            rows += m.size("row");
            for(int i=0;i<m.size("row");i++)
            {
                this.MatrixValues.add(m.extractMatrixToVector(i,"row"));
            }
        }
    }

    //34,35
    public Vector extractMatrixToVector(int index, String extractDirection) {

        Vector result = null;
        if(extractDirection.equals("row"))
        {
            result = this.MatrixValues.get(index).cloneSelf();
        }
        else
        {
            result = Factory.getVector(Factory.getScalar("0"),cols);
            for(int i=0;i<cols;i++)
            {
                result.setAt(this.getMatrixAt(index,i),i);
            }
        }

        return result;
    }

    //36
    public Matrix extractSubMatrix(int beginRow, int endRow, int beginColumn, int endColumn) {
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),endRow-beginRow,endColumn-beginColumn);

        for(int i=beginRow;i<endRow;i++)
        {
            for(int j=beginColumn;j<endColumn;j++)
            {
                result.setMatrixAt(i-beginRow,j-beginColumn,this.getMatrixAt(i,j));
            }
        }

        return result;
    }

    //37
    public Matrix extractSubMatrix(int exceptingRow, int exceptingColumn) {
        System.out.println("extractSubMatrix(제외) 호출 성공");
        return null;
    }

    //38
    public Matrix getTranspose() {
        System.out.println("getTranspose 호출 성공");
        return null;
    }

    //39
    public Scalar getTrace() {
        System.out.println("getTrace 호출 성공");
        return null;
    }

    //40
    public boolean isSquareMatrix() {
        System.out.println("isSquareMatrix 호출 성공");
        return false;
    }

    //41
    public boolean isUpperTriangularMatrix() {
        System.out.println("isUpperTriangularMatrix 호출 성공");
        return false;
    }

    //42
    public boolean isLowerTriangularMatrix() {
        System.out.println("isLowerTriangularMatrix 호출 성공");
        return false;
    }

    //43
    public boolean isIdentityMatrix() {
        System.out.println("isIdentityMatrix 호출 성공");
        return false;
    }

    //44
    public boolean isZeroMatrix() {
        System.out.println("isZeroMatrix 호출 성공");
        return false;
    }

    //45
    public void swapRow(int A, int B) {
        System.out.println("swapRow 호출 성공");
    }

    //46
    public void swapColumn(int A, int B) {
        System.out.println("swapColumn 호출 성공");
    }

    //47,48
    public void multiplyByScalar(Scalar value, String multiplyCondition) {
        System.out.println("multiplyByScalar 호출 성공");
    }

    //49
    public void addMultipliedRow(int A, int B, Scalar multiplyValue) {
        System.out.println("addMultipliedRow 호출 성공");
    }

    //50
    public void addMultipliedColumn(int A, int B, Scalar multiplyValue) {
        System.out.println("addMultipliedColumn 호출 성공");
    }

    //51
    public Matrix getRREF() {
        System.out.println("getRREF 호출 성공");
        return null;
    }


    //52
    public boolean isRREF() {
        System.out.println("isRREF 호출 성공");
        return false;
    }

    //53
    public Scalar getDeterminant() {
        System.out.println("getDeterminant 호출 성공");
        return null;
    }

    //54
    public Matrix getReversed() {
        System.out.println("getReversed 호출 성공");
        return null;
    }


//    public void add(Scalar val) {
//        System.out.println("Vector add 호출 성공");
//    }

//    public void subtract(Scalar val) {
//        System.out.println("Vector subtract 호출 성공");
//    }

//    public void multiply(Scalar val) {
//        System.out.println("Vector multiply 호출 성공");
//    }

//    public void divide(Scalar val) {
//        System.out.println("Vector divide 호출 성공");
//    }

//    public int getSize() {
//        System.out.println("Vector getSize 호출 성공");
//        return 0;
//    }

//    public Scalar get(int index) {
//        System.out.println("Vector get 호출 성공");
//        return null;
//    }

//    public void set(int index, Scalar val) {
//        System.out.println("Vector set 호출 성공");
//    }


    //17m
    @Override
    protected Matrix clone() {

        return null;
    }

    // 생성자들
    //6 지정한 하나의 값을 모든 요소의 값으로 하는 m*n 행렬 생성
    MatrixImpl(Scalar val, int m, int n) {
        rows = m;
        cols = n;
        MatrixValues = new java.util.Vector<>();

        for(int i=0;i<m;i++) {
            Vector tempRow = Factory.getVector(val,n);
            MatrixValues.add(tempRow);
        }
    }

    //7 i 이상 j 미만의 무작위 값을 요소로 하는 m * n 행렬 생성
    MatrixImpl(int i, int j, int m, int n) {
        this.rows = m;
        this.cols = n;

        MatrixValues = new java.util.Vector<>();
        for(int k=0;k<m;k++)
        {
            Vector tempRow = Factory.getVector(i,j,n);
            MatrixValues.add(tempRow);
        }
    }

    //8 csv 파일로 부터 m*n 행렬 생성
    //수정 필요
    MatrixImpl(File val, int m, int n) {
        this.rows = m;
        this.cols = n;

        MatrixValues = new java.util.Vector<>();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(val));
            String line = "";
            while((line = br.readLine())!=null)
            {
                Vector tempVector = Factory.getVector(Factory.getScalar("0"),n);
                String[] lineArr = line.split(",");
                for(int i=0;i<n;i++)
                {
                    tempVector.setAt(Factory.getScalar(lineArr[i]),i);
                }
                MatrixValues.add(tempVector);
            }
        }
        catch(Exception e)
        {
//            System.out.println("error");
        }

    }

    //9 2차원 배열로부터 m*n 행렬 생성
    MatrixImpl(int[][] arr, int m, int n) {
        this.rows = m;
        this.cols = n;

        MatrixValues = new java.util.Vector<>();

        for(int i=0;i<m;i++)
        {
            Vector tempVector = Factory.getVector(arr[i]);
            MatrixValues.add(tempVector);
        }
    }

    //10 단위 행렬 생성
    //크기는 어떻게 되는 걸까요..?
    MatrixImpl(int n) {
        this.rows = n;
        this.cols = n;

        MatrixValues = new java.util.Vector<>();

        for(int i=0;i<n;i++)
        {
            Vector tempVector = Factory.getVector(Factory.getScalar("0"),n);
            tempVector.setAt(Factory.getScalar("1"),i);

            MatrixValues.add(tempVector);
        }
    }

    //17s 객체 복제(Impl에서 override)
    public Matrix cloneSelf() {
        return clone();
    }

    //28 전달받은 두 행렬의 덧셈
    static Matrix addMatrixEach(Matrix A, Matrix B) {
        Matrix resultof28 = null;
        return resultof28;
    }

    //29 전달받은 두 행렬의 곱셈
    static Matrix multiplyMatrixEach(Matrix A, Matrix B) {
        Matrix resultof29 = null;
        //구현 필요
        return resultof29;
    }
}