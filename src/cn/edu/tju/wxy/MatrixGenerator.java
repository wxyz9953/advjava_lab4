
package cn.edu.tju.wxy;


public class MatrixGenerator {
	public static double[][] newMatrix(int row, int col) {
		double[][] retList = new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				double tmp = Math.random() * 100;
				double number = tmp/10;
				retList[i][j] = number;
			}
		}
		return retList;
	}
}
