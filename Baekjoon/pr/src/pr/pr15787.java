// 백준 115824428번
// n개의 기차가 있음.
// 기차는 20개의 일렬로 된 좌석이 있고, 한 개의 좌석에는 한 명의 사람이 탈 수 있다.
// 기차의 번호를 1번부터 n번으로 매길 때, 어떠한 기차에 대하여 m개의 명령이 주어진다.
// M번의 명령 후에 1번째 기차부터 순서대로 한 기차씩 은하수를 건너는데 조건이 있다.
// 기차는 순서대로 지나가며 기차가 지나갈 때 승객이 앉은 상태를 목록에 기록하며
// 이미 목록에 존재하는 기록이라면 해당 기차는 은하수를 건널 수 없다.
// 처음에 주어지는 기차에는 아무도 사람이 타지 않는다.
// 은하수를 건널 수 있는 기차의 수를 출력하는 문제.
// 명령의 종류는 문제 참조.
// 방법---------------------
// 첫 줄에 기차 수 n과 명령 수 m을 입력 받음.
// 다음 줄부터 m줄에 걸쳐 명령들을 입력 받음.
// 명령에 따라 비트마스킹 하면서 처리
// 오답노트------------------
// 명령 받는 for문에서 해시셋에 add 하면
// 상태가 바뀔 때 마다 add되므로 명령 받는 for문 밖에서
// for문 따로 구현해 중복 제거하고 output 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class pr15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] train = new long[n+1];
		Set<Long> pass = new HashSet<>();
		for(int a=0; a<m; a++) {
			// 입력 2
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			// 명령 1 - i번째 기차 x번 좌석에 사람을 태우기
			if(input == 1) {
				int x = Integer.parseInt(st.nextToken());
				train[i] |= ((long)1 << (x - 1));
			}
			// 명령 2 - i번째 기차 x번 좌석에서 하차
			else if(input == 2) {
				int x = Integer.parseInt(st.nextToken());
				train[i] &= ~((long)1 << (x - 1));
			}
			// 명령 3 - i번째 기차 승객들을 모두 한 칸 뒤로 밀기
			else if(input == 3)
				train[i] = (train[i] << 1) & (((long)1 << 20) - 1);	// 맨 뒷자리는 하차
			// 명령 4 - i번째 기차의 승객들을 모두 한 칸 앞으로 밀기
			else
				train[i] >>= 1;
		}
		int output = 0;
		for(int i=1; i<=n; i++) {
			if(pass.contains(train[i]))
				continue;
			else {
				pass.add(train[i]);									// 조합 등록
				output++;
			}
		}
		// 출력
		System.out.print(output);
	}
}