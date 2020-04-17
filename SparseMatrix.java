import java.io.FileNotFoundException;

public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        firstColumn = new MatrixColumn();
        MatrixColumn tempColumn = firstColumn;


        for(int i = 1; i < totalColumns; i++){
            // set the temp pointer's successor to a new MatrixColumn
            MatrixColumn newColumn = new MatrixColumn();
            tempColumn.setNext(newColumn);
            // update the temp pointer to its successor
            tempColumn = newColumn;
        }

        firstRow = new MatrixRow();
        MatrixRow tempRow = firstRow;

        for(int j = 1; j < totalRows; j++) {
            // set the temp pointer's successor to a new MatrixRow
            MatrixRow newRow = new MatrixRow();
            tempRow.setNext(newRow);
            // update the temp pointer to its successor
            tempRow = newRow;
        }

    }

    public void insert(int row, int column, int value) {
        ValueNode node = new ValueNode(row, column, value);
        // get the MatrixRow of row and insert the node
        MatrixRow currentRow = getRow(row);
        currentRow.insert(node);
        // same as above with column
        MatrixColumn currentColumn = getColumn(column);
        currentColumn.insert(node);
    }


    public MatrixRow getRow(int position) {
        MatrixRow temp = firstRow;
        // get to the correct  matrixRow and return it
        for(int i = 1; i < position; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn temp = firstColumn;
        for(int i = 1; i < position; i ++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public int getValue(int row, int column) {
        MatrixRow theRow = getRow(row);
        int val = theRow.get(column);
        //System.out.println("row: " + row);
        //System.out.println("column: " + column);
        //MatrixColumn theColumn = getColumn(column);
        //int val1 = theColumn.get(row);
        return val;
    }

    public void print() {
        for(int i = 1; i <= totalRows; i ++) {
            for(int j = 1; j <= totalColumns; j ++) {
                System.out.print(getValue(i,j) + "\t");
            }
            System.out.println();
        }
    }

    public SparseMatrix transpose() {
        SparseMatrix transposed = new SparseMatrix(this.totalColumns,this.totalRows);
        for(int i = 1; i <= this.totalRows; i++) {
            for(int j = 1; j <= this.totalColumns; j++) {
                transposed.insert(j, i, getValue(i, j));
            }
        }
        return transposed;
    }

    public SparseMatrix product(SparseMatrix other) {
        int sum = 0;
        SparseMatrix matrixA = this;
        SparseMatrix matrixB = other;
        SparseMatrix product = new SparseMatrix(matrixA.totalRows, matrixB.totalColumns);

        for(int i = 1; i <= matrixA.totalRows; i ++) {
            for(int j = 1; j <= matrixB.totalColumns; j ++) {
                for(int k = 1; k <= matrixA.totalColumns; k++) {
                    sum += (matrixA.getValue(i,k)) * (matrixB.getValue(k,j));
                }
                product.insert(i,j,sum);
                sum = 0;
            }
        }
        return product;
    }
}
