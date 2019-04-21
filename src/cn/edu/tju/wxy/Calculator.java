package cn.edu.tju.wxy;

//import java.util.List;

public class Calculator {
	private Strategy strategy;
	public static double[][] matrix1;
	public static double[][] matrix2;

	public Calculator(Strategy s, double[][] matrix1, double[][] matrix2) {
		this.strategy = s;
		Calculator.matrix1 = matrix1;
		Calculator.matrix2 = matrix2;
	}

	public double[][] calculate() throws Exception {
		int col = matrix2.length;
		int row = matrix1[0].length;
		if (col != row) {
			throw new Exception("¾ØÕó²ÎÊý´íÎó");
		}
		double[][] matrix = strategy.getResult(matrix1, matrix2);
		return matrix;
	}

}
