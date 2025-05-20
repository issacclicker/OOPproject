package tensor;

import java.io.File;

public class MatrixImpl implements Matrix {
    //행렬의 자료구조
    java.util.Vector<Vector> MatrixValues;

    //6 지정한 하나의 값을 모든 요소의 값으로 하는 m*n 행렬 생성
    MatrixImpl(Scalar val, int m, int n)
    {

    }

    //7 i 이상 j 미만의 무작위 값을 요소로 하는 m * n 행렬 생성
    MatrixImpl(int i, int j, int m, int n)
    {

    }

    //8 csv 파일로 부터 m*n 행렬 생성
    //수정 필요
    MatrixImpl(File val, int m, int n)
    {

    }

    //9 2차원 배열로부터 m*n 행렬 생성
    MatrixImpl(int[][] arr,int m, int n)
    {

    }

    //10 단위 행렬 생성
    //크기는 어떻게 되는 걸까요..?
    MatrixImpl()
    {

    }

    //17s 객체 복제(Impl에서 override)
    public Matrix cloneSelf()
    {
        return clone();
    }
    @Override
    protected Matrix clone()
    {
        return null;
    }

    //28 전달받은 두 행렬의 덧셈
    static Matrix addMatrixEach(Matrix A, Matrix B)
    {
        //구현 필요
        return null;
    }

    //29 전달받은 두 행렬의 곱셈
    static Matrix multiplyMatrixEach(Matrix A, Matrix B)
    {
        //구현 필요
        return null;
    }
}
