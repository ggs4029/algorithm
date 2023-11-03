// 백준 1436번
// n번째 종말의 수 구하기
// 종말의 수 : 666이 들어가는 수
// 방법------------------------
// n을 입력 받고
// for문을 통해 n번째 종말의 수를 찾는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n입력
		int n = Integer.parseInt(br.readLine());
		// n번째 종말의 수 찾기
		int num = 666; // 초기설정(첫번째 종말의 수)
		int sum = 1;
		String s = "";
		while (sum != n) {
			++num;
			// int를 string으로 바꿔주고 666을 포함하고 있는지 검사
			s = num + "";
			if (s.contains("666")) { // 666을 포함하고 있으면
				++sum;
			}
		}
		// 출력
		System.out.print(num);
	}
}