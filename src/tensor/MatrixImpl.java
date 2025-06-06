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
        if(i<0||i>=rows || j<0||j>=cols)
        {
            throw new IndexOutOfBounds("");
        }
        MatrixValues.get(i).setAt(val,j);
    }

    public Scalar getMatrixAt(int i, int j) {
        if(i<0||i>=rows || j<0||j>=cols)
        {
            throw new IndexOutOfBounds("");
        }
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
        if(this.cols != m.size("col") || this.rows != m.size("row"))
        {
            throw new MatrixSumSizeMismatch("");
        }


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
        if(this.cols != m.size("col") || this.rows != m.size("row"))
        {
            throw new MatrixMultiplySizeMismatch("");
        }

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
            if(this.rows != m.size("row"))
            {
                throw new MatrixColumnSizeMismatch("");
            }


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
            if(this.cols != m.size("col"))
            {
                throw new MatrixColumnSizeMismatch("");
            }


            rows += m.size("row");
            for(int i=0;i<m.size("row");i++)
            {
                this.MatrixValues.add(m.extractMatrixToVector(i,"row"));
            }
        }
    }

    //34,35
    public Vector extractMatrixToVector(int index, String extractDirection) {

        if(index<0||index>=rows||index>=cols)
        {
            throw new IndexOutOfBounds("");
        }


        Vector result = null;
        if(extractDirection.equals("row") || extractDirection.equals("h"))
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
        if(beginRow<0||beginRow>=rows || endRow<0||endRow>=rows || beginColumn<0||beginColumn>=cols || endColumn<0||endColumn>=cols)
        {
            throw new IndexOutOfBounds("");
        }

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
        if(exceptingRow<0||exceptingRow>=rows || exceptingColumn<0||exceptingColumn>=cols)
        {
            throw new IndexOutOfBounds("");
        }

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
        if(A<0||A>=rows || B<0||B>=rows)
        {
            throw new IndexOutOfBounds("");
        }

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
        if(A<0||A>=cols || B<0||B>=cols)
        {
            throw new IndexOutOfBounds("");
        }

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
        if(A<0||A>=rows || B<0||B>=rows)
        {
            throw new IndexOutOfBounds("");
        }

        for(int i=0;i<cols;i++)
        {
            this.setMatrixAt(B,i,Tensors.addScalarEach(getMatrixAt(B,i),Tensors.multiplyScalarEach(multiplyValue,this.getMatrixAt(A,i))));
        }
    }

    //50
    public void addMultipliedColumn(int A, int B, Scalar multiplyValue) {
        if(A<0||A>=cols || B<0||B>=cols)
        {
            throw new IndexOutOfBounds("");
        }

        for(int i=0;i<rows;i++)
        {
            this.setMatrixAt(i,B,Tensors.addScalarEach(getMatrixAt(i,B),Tensors.multiplyScalarEach(multiplyValue,this.getMatrixAt(i,A))));
        }
    }

    //51
    public Matrix getRREF() {
        MatrixImpl A = (MatrixImpl) this.clone();

        int rowCount = A.rows;
        int colCount = A.cols;
        int lead = 0;


        for (int r = 0; r < rowCount; r++) {
            if (lead >= colCount) {
                break;
            }

            int i = r;

            while (i < rowCount &&
                    A.getMatrixAt(i, lead).equals(Factory.getScalar("0"))) {
                i++;
            }

            if (i == rowCount) {
                lead++;
                r--;
                continue;
            }

            A.swapRow(i, r);

            Scalar pivotVal = A.getMatrixAt(r, lead);
            for (int c = 0; c < colCount; c++) {
                Scalar old = A.getMatrixAt(r, c);
                Scalar divided = Tensors.multiplyScalarEach(Factory.getScalar( Double.valueOf( 1.0 / Double.parseDouble( pivotVal.getScalar() ) ).toString() ), old);
                A.setMatrixAt(r, c, divided);
            }

            for (int k = 0; k < rowCount; k++) {
                if (k == r) {
                    continue;
                }
                Scalar factor = A.getMatrixAt(k, lead);
                if (factor.equals(Factory.getScalar("0"))) {
                    continue;
                }

                for (int c = 0; c < colCount; c++) {
                    Scalar toSubtract = Tensors.multiplyScalarEach(factor, A.getMatrixAt(r, c));
                    Scalar negativeOne = Factory.getScalar("-1");
                    Scalar minusProduct = Tensors.multiplyScalarEach(negativeOne, toSubtract);
                    Scalar newVal = Tensors.addScalarEach(A.getMatrixAt(k, c), minusProduct);
                    A.setMatrixAt(k, c, newVal);
                }
            }


            lead++;
        }


        return A;
    }


    //52
    public boolean isRREF() {
        if(this.getRREF().equals(this)) return true;
        return false;
    }

    //53
    public Scalar getDeterminant() {

        if(this.rows!=this.cols)
        {
            throw new CannotGetDeterminant("");
        }

        MatrixImpl A = (MatrixImpl) this.clone();
        int n = rows;

        Scalar det = Factory.getScalar("1");

        for (int i = 0; i < n; i++) {
            int pivotRow = i;
            while (pivotRow < n && A.getMatrixAt(pivotRow, i).equals(Factory.getScalar("0"))) {
                pivotRow++;
            }

            if (pivotRow == n) {
                return Factory.getScalar("0");
            }

            if (pivotRow != i) {
                A.swapRow(i, pivotRow);
                // det = det * (-1)
                det = Tensors.multiplyScalarEach(det, Factory.getScalar("-1"));
            }

            Scalar pivotVal = A.getMatrixAt(i, i);
            det = Tensors.multiplyScalarEach(det, pivotVal);

            double pivotDouble = Double.parseDouble(pivotVal.getScalar());
            double invPivotD  = 1.0 / pivotDouble;
            Scalar invPivot   = Factory.getScalar(Double.valueOf(invPivotD).toString());

            for (int j = i + 1; j < n; j++) {
                Scalar aji = A.getMatrixAt(j, i);
                Scalar factor = Tensors.multiplyScalarEach(aji, invPivot);

                for (int k = i; k < n; k++) {
                    Scalar aik      = A.getMatrixAt(i, k);
                    Scalar toSubtract = Tensors.multiplyScalarEach(factor, aik);

                    Scalar negativeOne = Factory.getScalar("-1");
                    Scalar minusProd   = Tensors.multiplyScalarEach(negativeOne, toSubtract);
                    Scalar oldVal      = A.getMatrixAt(j, k);
                    Scalar newVal      = Tensors.addScalarEach(oldVal, minusProd);

                    A.setMatrixAt(j, k, newVal);
                }
                A.setMatrixAt(j, i, Factory.getScalar("0"));
            }
        }
        return det;
    }

    //54
    public Matrix getReversed() {
        int n = rows;

        if(this.rows!=this.cols || this.getDeterminant().equals(Factory.getScalar("0")))
        {
            throw new CannotGetDeterminant("");
        }


        MatrixImpl A = (MatrixImpl) this.clone();
        MatrixImpl I = (MatrixImpl) Factory.getMatrix(n);

        for (int i = 0; i < n; i++) {
            int pivotRow = i;
            while (pivotRow < n && A.getMatrixAt(pivotRow, i).equals(Factory.getScalar("0"))) {
                pivotRow++;
            }

            if (pivotRow != i) {
                A.swapRow(i, pivotRow);
                I.swapRow(i, pivotRow);
            }

            Scalar pivotVal = A.getMatrixAt(i, i);
            double pivotD    = Double.parseDouble(pivotVal.getScalar());
            double invPivotD = 1.0 / pivotD;
            Scalar invPivot  = Factory.getScalar(Double.valueOf(invPivotD).toString());

            for (int c = 0; c < n; c++) {
                Scalar aOld = A.getMatrixAt(i, c);
                Scalar aNew = Tensors.multiplyScalarEach(aOld, invPivot);
                A.setMatrixAt(i, c, aNew);

                Scalar iOld = I.getMatrixAt(i, c);
                Scalar iNew = Tensors.multiplyScalarEach(iOld, invPivot);
                I.setMatrixAt(i, c, iNew);
            }

            for (int k = 0; k < n; k++) {
                if (k == i) continue;

                Scalar factor = A.getMatrixAt(k, i);
                if (factor.equals(Factory.getScalar("0"))) {
                    continue;
                }

                for (int c = 0; c < n; c++) {
                    Scalar aic      = A.getMatrixAt(i, c);
                    Scalar toSubtractA = Tensors.multiplyScalarEach(factor, aic);
                    Scalar oldAkc      = A.getMatrixAt(k, c);
                    Scalar minusA      = Tensors.multiplyScalarEach(Factory.getScalar("-1"), toSubtractA);
                    Scalar newAkc      = Tensors.addScalarEach(oldAkc, minusA);
                    A.setMatrixAt(k, c, newAkc);

                    Scalar iic         = I.getMatrixAt(i, c);
                    Scalar toSubtractI = Tensors.multiplyScalarEach(factor, iic);
                    Scalar oldIkc      = I.getMatrixAt(k, c);
                    Scalar minusI      = Tensors.multiplyScalarEach(Factory.getScalar("-1"), toSubtractI);
                    Scalar newIkc      = Tensors.addScalarEach(oldIkc, minusI);
                    I.setMatrixAt(k, c, newIkc);
                }

                A.setMatrixAt(k, i, Factory.getScalar("0"));
            }
        }

        return I;
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
        if(n < 1 || m < 1)
        {
            throw new DimensionCannotBeZero("");
        }

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
        if(n < 1 || m < 1)
        {
            throw new DimensionCannotBeZero("");
        }

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

        if(n < 1 || m < 1)
        {
            throw new DimensionCannotBeZero("");
        }

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

        if(n < 1 || m < 1)
        {
            throw new DimensionCannotBeZero("");
        }

        MatrixValues = new java.util.Vector<>();

        for(int i=0;i<m;i++)
        {
            Vector tempVector = Factory.getVector(arr[i]);
            MatrixValues.add(tempVector);
        }
    }

    //10 단위 행렬 생성
    MatrixImpl(int n) {

        if(n < 1)
        {
            throw new DimensionCannotBeZero("");
        }

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