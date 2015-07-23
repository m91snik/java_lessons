import local.mcalc.Calculator;
import local.mcalc.Matrix;

public class Main {

    public static void main(String[] args) {
        double[][] a ={{45,23,45},{56,67,78},{37,14,18},{67,67,67},{67,71,22}};
        double[][] b ={{34,23,45},{12,67,78},{37,56,18},{45,67,67},{23,71,22}};

        Matrix m1 = new Matrix(5,3);
        m1.setMatrixArray(a);
        Matrix m2 = new Matrix(5,3);
        m2.setMatrixArray(b);
        Matrix result;

        m1.print();
//        m1.transp();

        m2.print();

        result = Calculator.addition(m1,m2);
        result.print();





    }
}