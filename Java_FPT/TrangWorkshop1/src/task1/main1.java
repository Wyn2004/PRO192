package task1;

import java.util.Scanner;

public class main1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rows:");
		int rows = sc.nextInt();
		System.out.print("Enter number of colums");
		int colums = sc.nextInt();
		int[][] maxtrix = new int[rows][colums];
		int sum = 0;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < colums; j++) {
				System.out.print("Enter a[" + i + "][" + j + "]=");
				maxtrix[i][j] = sc.nextInt();
				sum+=maxtrix[i][j];
			}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++)
				System.out.format("%3d", maxtrix[i][j]);
			System.out.println();
		}
		
		System.out.println("Sum = "+sum);
		System.out.println("Average = "+(float) sum/(rows*colums));
		
		sc.close();
	}
}
