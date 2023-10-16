package org.csystem.util.matrix.test;

import static org.csystem.util.matrix.MatrixUtil.isSquareMatrix;

class IsSquareMatrixTest {
	public static void run()
	{
		int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int [][] b = {{1, 2, 3}, {4, 5, 6}};

		System.out.println(isSquareMatrix(a) ? "Kare matris" : "Kare matris değil");
		System.out.println(isSquareMatrix(b) ? "Kare matris" : "Kare matris değil");
	}

	public static void main(String [] args)
	{
		run();
	}
}

