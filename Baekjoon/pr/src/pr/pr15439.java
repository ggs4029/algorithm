// 백준 15439
// 베라의 패션
// 서로 다른 색상인 조합의 가지수 출력하기
// 방법-------------------------
// n을 입력 받고
// n * (n-1) 을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		System.out.print(n*(n-1));
	}
}