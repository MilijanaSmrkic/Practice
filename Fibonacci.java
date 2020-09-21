package task2;

import java.util.Scanner;

public class Fibonacci {

	public static int fib(int n) {

		int f[] = new int[n + 2];
		int i;

		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {

			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];

	}

	public static void main(String[] args) {
		System.out.println("To which element we print the Fibonacci array: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++)
			System.out.print(fib(i) + ", ");
	}
}
