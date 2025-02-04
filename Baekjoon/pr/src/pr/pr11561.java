// 백준 11561번
// 징검다리를 건널려는데 징검다리를 모두 밟고 싶지는 않았던 승택이는
// 제자리뛰기 실력을 발휘해 적절한 개수의 징검다리만을 밟고 가기로 했음.
// 징검다리를 건너는 규칙은 문제 참조.
// 승택이가 규칙을 지키며 강을 건널 때, 밟을 수 있는 징검다리의 최대 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스는 한 줄이고 징검다리의 총 수 n이 주어짐.
// n번 징검다리를 무조건 건너고 최대한 많이 건너려면
// 걍 1, 2, 3, ...이렇게 1부터 시작하면 되는거 아닌가 이러면 n번도 무조건 밟음.
// 이분탐색 하면서 n이하인 등차수열 합의 최대값 low 구해 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr11561 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			long n = Long.parseLong(br.readLine());
			// 밟을 수 있는 징검다리 최대 수 구하기
			long low = 1;
			long high = 1_000_000_000L;
			while(low+1 < high) {
				long mid = (low + high) / 2;
				long tmp = mid * (mid + 1) / 2;			// 등차수열 합
				if(tmp > n)								// 초과하면
					high = mid;							// high 범위 줄이고
				else if(tmp <= n)
					low = mid;
			}
			sb.append(low).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}