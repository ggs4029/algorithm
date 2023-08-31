// 백준 2292번
// 벌집 (최소 몇개의 방을 지나는지)
// 문제에서 주어진 법칙에 따라
// 1번방에서 N번방으로 이동할 때 지나는 방의 최소 개수를 구하는 문제
// 방법--------------------------
// N의 범위에 따라 if문을 돌린다.
// 1. N = 1인 경우 (최소)
// 		가장 가운데 방이 1이므로 답은 1
// 2. N >= 2인 경우
//		벌집의 개수는 한겹마다 6의 배수로 증가하니까
//		N의 범위 또한 2 + 6 * n 으로 일반항으로 바꿀수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력받기
		int N = Integer.parseInt(br.readLine());
		int answer = 1; // 초기답
		int count = 2; // N>=2일때 초기 벌집의 최소 개수
		// if문을 통해 계산
		if (N == 1) {
			System.out.print(1);
		} else {
			while (true) {
				if (count > N) // N의 범위보다 벌집의 개수가 커지게 되면 break
					break;
				count = count + 6 * answer; // N의 범위 계산
				answer++; // 정답 +1
			}
			System.out.print(answer);
		}
	}
}