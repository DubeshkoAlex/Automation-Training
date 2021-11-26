import actions.Create;
import actions.GetInfo;
import actions.OperationWithMatrix;
import actions.Output;

public class Tasks {
    public static void task1(){
        int matrixSize = GetInfo.getInt("Please input the size of matrix: ");
        boolean columnOrRowSort = GetInfo.getBoolean("Please input the type of sort: by column - true, by row - false: ");
        int numberOfRowOrColumn = GetInfo.getInt("Please input the number of row or column from 1 to "+ matrixSize + ": ")-1;
        int[][] matrix = Create.randomMatrix(matrixSize,100);
        Output.matrix(matrix);
        System.out.println("\n \n");
        OperationWithMatrix.sortMatrix(matrix,numberOfRowOrColumn,columnOrRowSort);
        Output.matrix(matrix);
    }
    public static void task2(){
        int matrixSize = GetInfo.getInt("Please input the size of matrix: ");
        boolean raise = GetInfo.getBoolean("asc - true, desc - false");
        int[][] matrix = Create.randomMatrix(matrixSize,100);
        Output.matrix(matrix);
        System.out.println("Count of asc(desc) numbers: ");
        OperationWithMatrix.countRaise(matrix,raise);
    }
}
