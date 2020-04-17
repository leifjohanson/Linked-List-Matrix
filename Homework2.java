
public class Homework2 {
    public void run() {
        MatrixReader read = new MatrixReader();
        SparseMatrix matrixA = read.read("matrixA.txt");
        System.out.println("matrixA: ");
        matrixA.print();
        SparseMatrix matrixB = read.read("matrixB.txt");
        System.out.println("\nmatrixB: ");
        matrixB.print();
        SparseMatrix aTransposed = matrixA.transpose();
        System.out.println("\nmatrixA Transpose: ");
        aTransposed.print();
        SparseMatrix bTransposed = matrixB.transpose();
        System.out.println("\nmatrixB Transpose: ");
        bTransposed.print();
        SparseMatrix product = matrixA.product(matrixB);
        System.out.println("\nmatrixA * matrixB: ");
        product.print();
    }
}
