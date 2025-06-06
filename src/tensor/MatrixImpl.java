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
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),endRow-beginRow+1,endColumn-beginColumn+1);

        for(int i=beginRow;i<endRow+1;i++)
        {
            for(int j=beginColumn;j<endColumn+1;j++)
            {
                result.setMatrixAt(i-beginRow,j-beginColumn,this.getMatrixAt(i,j));
            }
        }

        return result;
    }

    //37
    public Matrix extractSubMatrix(int exceptingRow, int exceptingColumn) {
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),rows-1,cols-1);

        boolean rowCondition = false;
        for(int i=0;i<rows;i++)
        {
            if(exceptingRow==i)
            {
                rowCondition = true;
                continue;
            }

            boolean colCondition = false;
            for(int j=0;j<cols;j++)
            {
                if(exceptingColumn==j)
                {
                    colCondition = true;
                    continue;
                }

                int wantRow = i;
                int wantCol = j;

                if(rowCondition) wantRow--;
                if(colCondition) wantCol--;

                result.setMatrixAt(wantRow,wantCol,this.getMatrixAt(i,j));
            }
        }

        return result;
    }

    //38
    public Matrix getTranspose() {
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),cols,rows);

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result.setMatrixAt(j,i,this.getMatrixAt(i,j));
            }
        }

        return result;
    }

    //39
    public Scalar getTrace() {
        Scalar result = Factory.getScalar("0");

        for(int i=0;i<rows;i++)
        {
            result.addScalar(this.getMatrixAt(i,i));
        }
        return result;
    }

    //40
    public boolean isSquareMatrix() {
        return rows==cols;
    }

    //41
    public boolean isUpperTriangularMatrix() {

        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(!getMatrixAt(i,j).equals(Factory.getScalar("0")))
                {
                    return false;
                }
            }
        }

        return true;
    }

    //42
    public boolean isLowerTriangularMatrix() {

        Matrix temp = this.getTranspose();
        return temp.isUpperTriangularMatrix();
    }

    //43
    public boolean isIdentityMatrix() {
        Matrix temp = Factory.getMatrix(rows);
        return temp.equals(this);
    }

    //44
    public boolean isZeroMatrix() {
        Matrix temp = Factory.getMatrix(Factory.getScalar("0"),rows,cols);
        return temp.equals(this);
    }

    //45
    public void swapRow(int A, int B)
    {
        for(int i=0;i<cols;i++)
        {
            Scalar temp = this.getMatrixAt(A,i);
            this.setMatrixAt(A,i,this.getMatrixAt(B,i));
            this.setMatrixAt(B,i,temp);
        }
    }

    //46
    public void swapColumn(int A, int B)
    {
        for(int i=0;i<rows;i++)
        {
            Scalar temp = this.getMatrixAt(i,A).cloneSelf();
            this.setMatrixAt(i,A,this.getMatrixAt(i,B));
            this.setMatrixAt(i,B,temp);
        }
    }

    //47,48
    public void multiplyByScalar(Scalar value, int index, String multiplyCondition)
    {
        if(multiplyCondition.equals("row"))
        {
            for(int i=0;i<cols;i++)
            {
                this.setMatrixAt(index,i,Tensors.multiplyScalarEach(value,this.getMatrixAt(index,i)));
            }
        }
        else
        {
            for(int i=0;i<rows;i++)
            {
                this.setMatrixAt(i,index,Tensors.multiplyScalarEach(value,this.getMatrixAt(i,index)));
            }
        }
    }

    //49
    public void addMultipliedRow(int A, int B, Scalar multiplyValue)
    {
        for(int i=0;i<cols;i++)
        {
            this.setMatrixAt(B,i,Tensors.addScalarEach(getMatrixAt(B,i),Tensors.multiplyScalarEach(multiplyValue,this.getMatrixAt(A,i))));
        }
    }

    //50
    public void addMultipliedColumn(int A, int B, Scalar multiplyValue) {
        for(int i=0;i<rows;i++)
        {
            this.setMatrixAt(i,B,Tensors.addScalarEach(getMatrixAt(i,B),Tensors.multiplyScalarEach(multiplyValue,this.getMatrixAt(i,A))));
        }
    }

    //51
    public Matrix getRREF() {
        System.out.println("getRREF 호출 성공");
        return null;
    }


    //52
    public boolean isRREF() {
        if(this.getRREF().equals(this)) return true;
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


    //17m
    @Override
    protected Matrix clone() {
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),rows,cols);

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result.setMatrixAt(i,j,this.getMatrixAt(i,j));
            }
        }

        return result;
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
        Matrix result = A.cloneSelf();
        result.addMatrix(B);
        return result;
    }

    //29 전달받은 두 행렬의 곱셈
    static Matrix multiplyMatrixEach(Matrix A, Matrix B) {
        Matrix result = B.cloneSelf();
        result.multiplyMatrix(A,"right");
        return result;
    }
}