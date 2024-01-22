// 백준 24723
// 녹색거탑
// 방법-------
// 층수 n을 입력 받고
// 2의 n승을 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int sum = 1;
		for(int x=1; x<=n; x++) {
			sum *= 2;
		}
		// 출력
		System.out.print(sum);
	}
}