package cn.edu.tju.wxy;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		double[][] matrix1 = MatrixGenerator.newMatrix(150, 250);
		double[][] matrix2 = MatrixGenerator.newMatrix(250, 150);
//		 Main.printMatrix(matrix1);
//		 Main.printMatrix(matrix2);
		
		double[][] result1 = null;
		double[][] result2 = null;

		Strategy s = new SingleThreadStrategy();
		Calculator c = new Calculator(s, matrix1, matrix2);
		try {
			long start = System.currentTimeMillis();
			result1 = c.calculate();
			System.out.print("单线程运行时间(ms)：");
			System.out.println(System.currentTimeMillis() - start);
//			Main.printMatrix(result1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		int threadNum = 5;
		Strategy s1 = new MultiThreadStrategy(threadNum);
		Calculator c1 = new Calculator(s1, matrix1, matrix2);
		try {
			long start = System.currentTimeMillis();
			result2 = c1.calculate();
			
			assert Arrays.deepEquals(result1, result2);
			
			System.out.print(threadNum);
			System.out.print("个线程运行时间(ms)：");
			System.out.println(System.currentTimeMillis() - start);
//			Main.printMatrix(result2);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		try {
//			long start = System.currentTimeMillis();
//			result2 = c1.calculate();
//			System.out.println(System.currentTimeMillis() - start);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		long total1 = 0 ;
//		long total2 = 0;
//		long start = 0;
//		for(int i = 0 ; i < 10 ; i++) {
//			try {
//				start = System.currentTimeMillis();
//				result2 = c1.calculate();
//				total2+= System.currentTimeMillis() - start;
////				start = System.currentTimeMillis();
////				result1 = c.calculate();
////				total1+= System.currentTimeMillis() - start;				
////				assert Arrays.deepEquals(result1, result2);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.print("单线程运行十次平均时间为: ");
//		System.out.println(total1/10);
//		System.out.print(threadNum);
//		System.out.print("个线程运行十次平均时间为: ");
//		System.out.println(total2/10);
		
	}

	
	
	
	
	public static void printMatrix(double[][] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				System.out.print(list[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
