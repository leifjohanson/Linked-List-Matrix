import java.io.File;
import java.util.Scanner;

public class MatrixReader {

    public SparseMatrix read(String file)  {
        try {
            File f = new File(file);

            Scanner s = new Scanner(f);
            String line1 = s.nextLine();
            int numRows = Integer.parseInt(line1);
            String line2 = s.nextLine();
            int numColumns = Integer.parseInt(line2);
            SparseMatrix sm = new SparseMatrix(numRows, numColumns);

            int rowNum = 0;
            while (s.hasNextLine()) {
                rowNum++;
                String currentRow = s.nextLine();
                String[] currentRowArray = currentRow.split(" ");
                for (int i = 0; i < currentRowArray.length; i++) {
                    String pair = currentRowArray[i];
                    String[] pairArray = pair.split(",");
                    int colNum = Integer.parseInt(pairArray[0]);
                    int val = Integer.parseInt(pairArray[1]);
                    sm.insert(rowNum, colNum, val);
                }
            }
            return sm;
        }
        catch(Exception e) {
            System.out.println("File not found.");
            return null;
        }

    }
}
