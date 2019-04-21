# 运行方法：

在Main.java中运行测试代码

1. 生成测试矩阵，以生成150*250矩阵为例：

   ```java
   double[][] matrix1 = MatrixGenerator.newMatrix(150, 250);
   ```

2. 实例化所需要的使用的策略

   ```java
   Strategy s = new SingleThreadStrategy();//单线程策略
   Strategy s1 = new MultiThreadStrategy(threadNum);//多线程策略，需要传入所使用的线程数
   ```

3. 实例化计算类Calculator

   传入参数为策略以及要计算的矩阵

   ```java
   Calculator c = new Calculator(s, matrix1, matrix2);
   ```

4. 调用Calculator的calculate方法，返回值为结果的二维数组

   ```java
   c.calculate();
   ```

   