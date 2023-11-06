// 백준 1402번
// 아무래도이문제는A번난이도인것같다
// 방법-------------------------
// 문제를 잘 읽으면
// a가 a'으로 변할 수 있고
// a'가 a''으로 변할 수 있으면
// a는 a''으로 변할 수 있다고 하였으므로
// 이를 다시 생각하면 그 어떤 수로도 변할수 있다는 뜻이다.
// 따라서 테스트 케이스의 개수 t와 두 정수 a,b를 입력 받고
// 그냥 yes를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1402 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		for (int x = 0; x < t; x++) {
			String input = br.readLine();
			// 출력
			System.out.println("yes");
		}
	}
}