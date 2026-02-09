// 백준 16471번
// 보드게임카페에서 “사장님과의 게임에서 이기면 무료, 지거나 비기면 5000원 추가 지불" 이벤트에 참여함.
// 자세한 게임 룰은 문제 참조.
// 내가 이길 확률이 조금이라도 있으면 참여하려 함.
// 사장님과 내가 받은 카드에 적힌 수들이 주어지면 게임을 해도 되는지 판단해서 출력하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받고
// 다음 줄에 주언이 카드 숫자 n개 한 줄에 입력 받음.
// 그 다음 줄에 사장님 카드 숫자 n개 한 줄에 입력 받음.
// 입력 받은거 따로 배열에 저장해주고
// 둘 다 정렬 해준 뒤에
// 내가 작은 카드부터 내면서 사장 카드 중에 이길 수 있는 카드 있는지 찾아보고
// n+1 / 2 이상 점수 먹을수 있는지 판단하고 답 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr16471 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] me = new int[n];
		int[] manager = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			me[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			manager[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(me);
		Arrays.sort(manager);
		// 카드게임 진행
		int win = 0;
		int tmp = 0;
		for(int i=0; i<n; i++) {
			if(win >= (n+1)/2)
				break;
			for(int j=tmp; j<n; j++) {
				if(me[i] < manager[j]) {
					win++;
					tmp = j + 1;
					break;
				}
			}

		}
		// 출력
		if(win >= (n+1)/2)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}