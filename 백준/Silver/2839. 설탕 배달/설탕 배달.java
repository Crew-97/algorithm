import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		int answer = -1;

		/*
		 * 경우의수 3가지 1. 5만 쓴경우 2. 3만 쓴경우 3. 5, 3 같이 써야하는 경우
		 */

		for (int five = weight / 5; five >= 0; five--) {
			int rest = weight - five * 5;
			if (rest % 3 == 0) {
				answer = five + rest / 3;
				break;
			}

		}
		System.out.println(answer);

	}
}