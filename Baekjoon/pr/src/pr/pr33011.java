// 백준 향유회 A번 - 홀수와 짝수 게임
// n장의 카드가 일렬로 놓여 있음.
// 채완이와 희원이가 카드를 가지고 홀짝게임 할거임.
// 채완이부터 시작.
// 각 플레이어는 자신의 차례가 될 때마다 바닥에 남아있는 카드 중 한 장을 골라 들고 간다.
// 이때, 다음 조건을 만족하는 카드만 들고 갈 수 있다.
// 1. 각 플레이어가 첫 번째로 들고 갈 수 있는 카드에는 제약이 없다.
// 2. 이후 두 번째부터 들고 가는 카드는 반드시 자신이 첫 번째로 들고 간 카드와 홀짝 여부가 동일해야 한다.
// 3. 더 들고 갈 카드가 없으면 패배.
// 둘 다 최선의 전략을 사용할 때, 게임의 승자를 구하는 문제.
// 방법---------------------
// 테스트 케이스 t 입력 받음.
// 각 테스트 케이스는 n 입력 받는 줄, n개의 카드를 입력 받는 줄 두 줄임.
// 홀짝 개수 세서 게임 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr33011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			int odd = 0;
			int even = 0;
			String[] input = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(input[j]);
				if(tmp%2==1)
					odd++;
				else
					even++;
			}
			// 승자 판별
			if(odd==even)
				sb.append("heeda0528").append("\n");
			else if(odd>even) {
				// 채완 = 홀수;
				if(odd%2==1)
					sb.append("amsminn").append("\n");
				else
					sb.append("heeda0528").append("\n");
			}
			else {
				// 채완 = 짝수
				if(even%2==1)
					sb.append("amsminn").append("\n");
				else
					sb.append("heeda0528").append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}