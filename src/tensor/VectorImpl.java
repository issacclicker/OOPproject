package tensor;

import java.util.Random;

class VectorImpl implements Vector,Cloneable {
    //벡터의 자료구조
    java.util.Vector<Scalar> vectorValues = new java.util.Vector<Scalar>();
    private int dimension = 0;

    //3. 지정한 하나의 값을 모든 요소의 값으로 하는 n차원 벡터 생성
    VectorImpl(Scalar val, int n)
    {
        if(n < 1)
        {
            throw new DimensionCannotBeZero("");
        }

        dimension = n;
        for(int i=0;i<n;i++)
        {
            vectorValues.add(val.cloneSelf());
        }
    }

    //4. i 이상 j 미만의 무작위 값을 요소로 하는 n차원 벡터 생성
    VectorImpl(int i, int j, int n)
    {
        if(n < 1)
        {
            throw new DimensionCannotBeZero("");
        }

        dimension = n;
        for(int k=0;k<n;k++)
        {
            Scalar temp = Factory.getScalar(i,j);
            vectorValues.add(temp);
        }
    }

    //5. 1차원 배열로부터 n-차원 벡터 생성
    VectorImpl(int[] arr)
    {
        if(arr == null || arr.length < 1)
        {
            throw new DimensionCannotBeZero("");
        }


        dimension = arr.length;
        for(int i : arr)
        {
            vectorValues.add(Factory.getScalar((Integer.valueOf(i)).toString()));
        }
    }

    //11v. 특정 위치의 요소를 지정
    public void setAt(Scalar val,int index) {
        if(index<0||index>=dimension)
        {
            throw new IndexOutOfBounds("");
        }

        vectorValues.set(index,val);
    };

    //11v. 특정 위치의 요소를 조회
    public Scalar getAt(int index){
        if(index<0||index>=dimension)
        {
            throw new IndexOutOfBounds("");
        }

        return vectorValues.get(index);
    };

    //13v. 크기 정보 조회
    public int size(){
        return dimension;
    };

    //14v. 객체 콘솔에 출력
    @Override
    public String toString(){

        String result = "";

        for(int i=0;i<dimension;)
        {
            result = result + vectorValues.get(i).toString();
            i++;
            if(i!=dimension)
            {
                result = result + "\n";
            }
        }

        return result;
    }

    //15v. 객체의 동등성 판단
    @Override
    public boolean equals(Object o){

        if(this.toString().equals(o.toString()))
        {
            return true;
        }
        return false;
    }

    //17s 객체 복제(Impl에서 override)
    public Vector cloneSelf()
    {
        return clone();
    }
    @Override
    protected Vector clone()
    {
        Vector result = new VectorImpl(Factory.getScalar("0"),dimension);

        for(int i=0;i<dimension;i++)
        {
            result.setAt(this.getAt(i),i);
        }

        return result;
    }

    //20 다른 벡터와 덧셈
    public void addVector(Vector val){

        if(dimension != val.size())
        {
            throw new VectorSumSizeMismatch("");
        }

        for(int i=0;i<dimension;i++)
        {
            this.setAt(Tensors.addScalarEach(this.getAt(i),val.getAt(i)),i);
        }
    }

    //21 다른 스칼라와 곱셈
    @Override
    public void multiplyScalar(Scalar val){
        for(int i=0;i<dimension;i++)
        {
            this.setAt(Tensors.multiplyScalarEach(this.getAt(i),val),i);
        }
    }

    //26 전달 받은 두 벡터의 덧셈
    static Vector addVectorEach(Vector A,Vector B)
    {
        Vector result = A.cloneSelf();
        result.addVector(B);
        return result;
    }
    //27 전달 받은 스칼라와 벡터의 곱셈
    static Vector multiplyVectorScalar(Vector A,Scalar B)
    {
        Vector result = A.cloneSelf();
        result.multiplyScalar(B);
        return result;
    }

    //31 n-차원 벡터 객체를 자신으로 부터 1*n 행렬을 생성하여 반환
    public Matrix getRow(){
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),1,dimension);

        for(int i=0;i<dimension;i++)
        {
            result.setMatrixAt(0,i,vectorValues.get(i));
        }

        return result;
    }

    //30 n-차원 벡터 객체를 자신으로 부터 n*1 행렬을 생성하여 반환
    public Matrix getColumn(){
        Matrix result = Factory.getMatrix(Factory.getScalar("0"),dimension,1);

        for(int i=0;i<dimension;i++)
        {
            result.setMatrixAt(i,0,vectorValues.get(i));
        }

        return result;
    }

    //temp
    public void expansion(Scalar val)
    {
        vectorValues.add(val);
        dimension++;
    }
}
