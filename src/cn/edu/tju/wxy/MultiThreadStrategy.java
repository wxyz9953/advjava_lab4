package cn.edu.tju.wxy;

public class MultiThreadStrategy implements Strategy {

	private int threadNumber;

	public MultiThreadStrategy(int num) {
		this.threadNumber = num;
	}

	@Override
	public double[][] getResult(double[][] list1, double[][] list2) {
		for (int i = 0; i < threadNumber; i++) {
			Thread th = new Thread(new CalculatorThread(i, threadNumber));
			th.start();
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return CalculatorThread.res;

	}

}
