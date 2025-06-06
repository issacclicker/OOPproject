package test;

import tensor.*;

import java.io.File;

public class Fake {
    public static void main(String[] args)
    {
        int[][] arr = {{1,0,0},{0,2,0},{0,0,1}};
        Matrix mm = Factory.getMatrix(arr,3,3);

        Matrix tt = mm.extractSubMatrix(0,0,1,1);

        System.out.println(tt);
    }
}
