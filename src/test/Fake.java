package test;

import tensor.*;

public class Fake {
    public static void main(String[] args)
    {
        Scalar scalar1 = Factory.getScalar("3");
        Scalar scalar2 = scalar1.cloneSelf();
        Scalar scalar3 = Tensors.multiplyScalarEach(scalar1, scalar2);

        System.out.println(scalar3);
    }
}
