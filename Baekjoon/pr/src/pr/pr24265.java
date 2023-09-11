// 백준 24265번
// 문제에서 주어진 알고리즘속의
// 코드1의 수행 횟수와
// 수행 횟수를 다항식으로 나타내었을 때의 최고차항의 차수를 출력하는 문제
// 방법-----------------------
// 첫째 줄에 입력의 크기 n을 입력 받고
// 코드1의 수행 횟수를 계산해 출력한다.
// 1부터 n-1까지의 합이 코드1의 수행 횟수이다.
// 다항식으로 나타내었을 때의 최고차항의 차수는
// 중첩for문 안에 코드1이 있으니 2이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24265 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Integer.parseInt(br.readLine());
		// 계산
		// 최종 출력
		System.out.println((n-1)*n/2);
		System.out.print(2);

	}
}
