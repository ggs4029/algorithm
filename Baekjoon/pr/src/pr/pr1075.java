// 백준 1075번
// 정수 n의 가장 뒤 두자리를 적절히 바꿔
// 정수 f로 n이 나눠지게 만드는 문제
// 방법------------------------
// 첫째 줄에 n, 둘째 줄에 f 를 입력 받는다.
// 십의 자리랑 일의 자리를 0으로 만들고
// 예를 들어 n이 1050이면 1000~1099까지 for문을 돌려
// f로 나눠지면 십의자리와 일의자리면 출력하고 break로 탈출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Integer.parseInt(br.readLine());
		long f = Integer.parseInt(br.readLine());
		long num = n - n % 100;
		// 계산
		for (long x = num; x < num + 100; x++) { // 예를 들어 n이 1050이면 1000~1099까지 돌도록
			if (x % f == 0) { // 나머지 0이면
				// 출력
				if (x % 100 < 10)// 한자리이면 0을 추가해서 출력
					System.out.print("0" + x % 100);
				else
					System.out.print(x % 100);
				break;
			}
		}
	}
}