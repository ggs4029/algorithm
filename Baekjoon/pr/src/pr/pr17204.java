// 백준 17204번
// 술게임을 하는데 게임 참여자들간에 지목을 완료한 상태가 주어질때,
// 보성이가 벌주를 마시기 위해 영기가 불러야 하는 가장 작은 양의 정수 M을 보성이 몰래 귀띔해 주도록 하자.
// 김영기는 게임을 제안하였기에 자연스럽게 0번이 된다.
// 자세한 술게임 규칙은 문제 참고.
// 방법---------------------
// 첫 줄에 참여자 수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 i번 사람이 지목하는 사람의 번호가 주어짐.
// m을 1부터 n까지 늘려가며 술게임을 했을 때 마지막에 보성이가 걸리는지 확인하고
// 최소 m값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] game = new int[n];
		for(int i=0; i<n; i++)
			game[i] = Integer.parseInt(br.readLine());
		// 술게임 진행
		for(int m=1; m<=n; m++) {
			int tmp = 0;
			for(int i=0; i<m; i++)
				tmp = game[tmp];							// 지목자에게 이동
			if(tmp == k) {									// 마지막에 보성이가 걸리면
				System.out.print(m);						// m 출력하고 종료
				return;
			}
		}
		// 보성이가 모든 m에서 안걸렸으면
		System.out.print(-1);
	}
}