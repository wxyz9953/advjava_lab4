package cn.edu.tju.wxy;

public class CalculatorThread implements Runnable {

	public static double[][] res = new double[Calculator.matrix1.length][Calculator.matrix2[0].length];
	private int index;
	private int threadNum;
	private double[][] matrix1;
	private double[][] matrix2;

	public CalculatorThread(int index, int threadNum) {
		this.index = index;
		this.threadNum = threadNum;
		this.matrix1 = Calculator.matrix1;
		this.matrix2 = Calculator.matrix2;
	}

	@Override
	public void run() {
		int total = matrix1.length;
		for (int i = 0; i < total; i++) {
			if (i % threadNum == index) {
				double[] tmp = calculateOne(i);
				res[i] = tmp;
			}
		}
	}

	private double[] calculateOne(int index) {// 得到结果第index行
		int row = matrix1[0].length;
		int col = matrix2[0].length;
		double[] list = new double[col];
		for (int j = 0; j < col; j++) {
			double result = 0;
			for (int k = 0; k < row; k++) {
				result += matrix1[index][k] * matrix2[k][j];
			}
			list[j] = result;
		}
		return list;
	}

}
