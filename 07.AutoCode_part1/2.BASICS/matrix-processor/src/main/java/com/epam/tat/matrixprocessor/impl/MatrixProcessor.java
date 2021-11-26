package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {

	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {

		if(matrix==null){
			throw new MatrixProcessorException("Input matrix shouldn't be null!");
		}
		if(matrix.length == 0 || matrix[0].length==0){
			throw new MatrixProcessorException("Input matrix shouldn't be empty!");
		}
		if(matrix.length<1 || matrix.length>=10){
			throw new MatrixProcessorException("Count of rows is not in range 0 < countOfRows < 10");
		}
		if(matrix[0].length<1 || matrix[0].length>=10){
			throw new MatrixProcessorException("Count of columns is not in range 0 < countOfColumns < 10");
		}

		double[][] transposedMatrix = new double[matrix[0].length][matrix.length];

		for(int j = 0; j < matrix[0].length; j++){
			for (int i = 0; i < matrix.length; i++){
				transposedMatrix[j][i]=matrix[i][j];
			}
		}
		return transposedMatrix;
	}

	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {

		if(matrix==null){
			throw new MatrixProcessorException("Input matrix shouldn't be null!");
		}
		if(matrix.length == 0 || matrix[0].length==0){
			throw new MatrixProcessorException("Input matrix shouldn't be empty!");
		}
		if(matrix.length<1 || matrix.length>=10){
			throw new MatrixProcessorException("Count of rows is not in range 0 < countOfRows < 10");
		}
		if(matrix[0].length<1 || matrix[0].length>=10){
			throw new MatrixProcessorException("Count of columns is not in range 0 < countOfColumns < 10");
		}

		double[][] rotatedMatrix = new double[matrix[0].length][matrix.length];

		for(int j = 0, k = 0; j < matrix[0].length; j++, k++){
			for (int i = 0, l = matrix.length-1; i < matrix.length; i++, l--){
				rotatedMatrix[k][l] = matrix[i][j];
			}
		}

		return rotatedMatrix;
	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 *
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {

		if(firstMatrix==null || secondMatrix==null){
			throw new MatrixProcessorException("Input matrix shouldn't be null!");
		}
		if((firstMatrix.length == 0 || firstMatrix[0].length==0) || (secondMatrix.length == 0 || secondMatrix[0].length==0)){
			throw new MatrixProcessorException("Input matrix shouldn't be empty!");
		}
		if((firstMatrix.length<1 || firstMatrix.length>=10) || (secondMatrix.length<1 || secondMatrix.length>=10)){
			throw new MatrixProcessorException("Count of rows is not in range 0 < countOfRows < 10");
		}
		if((firstMatrix[0].length<1 || firstMatrix[0].length>=10) || (secondMatrix[0].length<1 || secondMatrix[0].length>=10)){
			throw new MatrixProcessorException("Count of columns is not in range 0 < countOfColumns < 10");
		}

		double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
		for (int i = 0; i < firstMatrix.length; i++){
			for (int j = 0; j < secondMatrix[0].length; j++){
				for (int k = 0; k < secondMatrix.length; ++k){
					resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
					resultMatrix[i][j] = BigDecimal.valueOf(resultMatrix[i][j]).setScale(3, RoundingMode.HALF_UP).doubleValue();
				}
			}
		}
		return resultMatrix;
	}

	/**
	 * This method returns the inverse of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {

		if(matrix==null){
			throw new MatrixProcessorException("Input matrix shouldn't be null!");
		}
		if(matrix.length == 0 || matrix[0].length==0){
			throw new MatrixProcessorException("Input matrix shouldn't be empty!");
		}
		if(matrix.length!=matrix[0].length){
			throw new MatrixProcessorException("Count of rows is not equal count of column");
		}
		if(matrix.length<1 || matrix.length>=10){
			throw new MatrixProcessorException("Count of rows is not in range 0 < countOfRows < 10");
		}
		if(matrix[0].length<1 || matrix[0].length>=10){
			throw new MatrixProcessorException("Count of columns is not in range 0 < countOfColumns < 10");
		}

		double[][] inverseMatrix = new double[matrix.length][matrix.length];
		double[][] newMatrix= new double[matrix.length-1][matrix.length-1];

		for(int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){

				for (int r = 0, l = 0; r < matrix.length; r++){
					if(r==i){
						continue;
					}
					for (int k = 0, p = 0; k < matrix.length; k++){
						if(k==j){
							continue;
						}
						newMatrix[l][p] = matrix[r][k];
						p++;
					}
					l++;
				}
				if(matrix.length>2){
					inverseMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * getMatrixDeterminant(newMatrix);
				}
				else {
					inverseMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * newMatrix[0][0];
				}
			}
		}

		inverseMatrix = transpose(inverseMatrix);
		double determinant = getMatrixDeterminant(matrix);

		if(determinant==0){
			throw new MatrixProcessorException("Determinant = 0. Inverse matrix doesn't exist");
		}

		for (int i = 0; i < inverseMatrix.length; i++){
			for (int j = 0; j < inverseMatrix.length; j++){
				inverseMatrix[i][j] = BigDecimal.valueOf(inverseMatrix[i][j]/determinant).setScale(3, RoundingMode.HALF_UP).doubleValue();
			}
		}
		return inverseMatrix;
	}

	/**
	 * This method returns the determinant of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {

		if(matrix==null){
			throw new MatrixProcessorException("Input matrix shouldn't be null!");
		}
		if(matrix.length == 0 || matrix[0].length==0){
			throw new MatrixProcessorException("Input matrix shouldn't be empty!");
		}
		if(matrix.length!=matrix[0].length){
			throw new MatrixProcessorException("Count of rows is not equal count of column");
		}
		if(matrix.length<1 || matrix.length>=10){
			throw new MatrixProcessorException("Count of rows is not in range 0 < countOfRows < 10");
		}
		if(matrix[0].length<1 || matrix[0].length>=10){
			throw new MatrixProcessorException("Count of columns is not in range 0 < countOfColumns < 10");
		}

		double determinant=0;

		if(matrix.length == 1){
			determinant = matrix[0][0];
		}
		else if(matrix.length == 2){
			determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		else {
			double[][] newMatrix = new double[matrix.length-1][matrix.length-1];
			for (int r = 0; r < matrix.length; r++) {

				for (int i = 1, l = 0; i < matrix.length; i++, l++) {
					for (int j = 0, k = 0; j < matrix.length; j++) {

						if (j == r) {
							continue;
						}

						newMatrix[l][k] = matrix[i][j];
						k++;
					}
				}

				determinant += Math.pow((-1), (2 + r)) * matrix[0][r] * getMatrixDeterminant(newMatrix);

			}

		}

		return determinant;
	}
}
