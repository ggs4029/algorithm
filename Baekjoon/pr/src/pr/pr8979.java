// 백준 8979번
// 각 국가의 금은동메달 정보를 입력 받고 특정 국가의 등수를 출력하는 문제.
// 등수를 정하는 자세한 규칙은 문제 참조.
// 방법---------------------
// 첫 줄에 국가의 수 n과 등수를 알고 싶은 국가 k를 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 국가의 번호와 금, 은 , 동메달 개수를 한 줄에 입력 받음.
// 모든 나라의 등수를 구하는 것이 아닌, 구하려는 국가의 등수를 1등이라고 놓고 시작해서
// 모든 나라랑 금, 은, 동메달 비교해가며 등수를 ++ 하는식으로 등수 정해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int medal[][] = new int[n+1][4];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			medal[num][0] = g;
			medal[num][1] = s;
			medal[num][2] = b;
		}
		// 등수 정하기
		int rank = 1;
		for(int i=1; i<=n; i++) {
			// 조건1 - 금메달 수가 더 많은 나라
			if(medal[i][0] > medal[k][0])
				rank++;
			// 조건2 - 금메달 수가 같으면, 은메달 수가 더 많은 나라
			else if(medal[i][0]==medal[k][0] && medal[i][1]>medal[k][1])
				rank++;
			// 조건3 - 금, 은메달 수가 같으면, 동메달 수가 더 많은 나라
			else if(medal[i][0]==medal[k][0] && medal[i][1]==medal[k][1] && medal[i][2]>medal[k][2])
				rank++;
		}
		// 출력
		System.out.print(rank);
	}
}