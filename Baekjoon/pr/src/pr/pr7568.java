// 백준 7568번
// 사람들의 키와 몸무게를 입력 받아 덩치 등수를 출력하는 문제
// 방법---------------------
// 첫 줄에 사람수 n, 다음줄부터 n줄에 걸쳐 사람들의 몸무게 키를 한줄에 입력 받음.
// 이중for문을 돌며 자기보다 덩치 등수를 계산
// 기본 등수를 1로 설정해놓고 자기보다 큰 사람이 올때마다 본인 등수에 +1을 해줌.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] person = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}
		// 덩치 등수 매기기
		int[] count = new int[n];
		for(int i=0; i<n; i++) {
			count[i] = 1;				// 기본 등수
			for(int j=0; j<n; j++) {
				if(i==j)				// 본인이면 건너뛰기
					continue;
				else {
					if(person[i][0]<person[j][0] && person[i][1]<person[j][1])
						count[i]++;
				}
			}
		}
		// 출력
		for(int i=0; i<n; i++) {
			System.out.print(count[i]+" ");
		}
	}
}