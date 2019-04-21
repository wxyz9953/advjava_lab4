package cn.edu.tju.wxy;

public class SingleThreadStrategy implements Strategy {

	@Override
	public double[][] getResult(double[][] list1, double[][] list2) {
		double[][] res = new double[list1.length][list2[0].length];
		int row1 = list1.length;
		int col1 = list1[0].length;
		int row2 = col1;
		int col2 = list2[0].length;
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				double result = 0;
				for (int k = 0; k < row2; k++) {
					result += list1[i][k] * list2[k][j];
				}
				res[i][j] = result;
			}
		}
		return res;
	}

}
