package test;

import tensor.*;

import java.io.File;

public class Fake {
    public static void main(String[] args)
    {
        int[][] arr = {{1,1,0},{0,0,0},{0,1,0}};
        Matrix mm = Factory.getMatrix(arr,3,3);

        mm.addMultipliedColumn(1,0,Factory.getScalar("3"));

        System.out.println(mm);
    }
}
