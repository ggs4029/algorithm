// 백준 1072번
// 게임 횟수 x와 이긴 게임 y(z%)가 주어지면
// 형택이가 게임을 최소 몇 번 더 해야 z가 변하는지 구하는 문제.
// 방법---------------------
// 첫 줄에 x, y가 주어짐.
// 이분탐색 하면서 승률 변하면 기록하고
// 오른쪽 포인터 왼쪽으로 옮겨서 승률 변하는지 다시해보고
// 최종 결과를 출력.
// 오답노트------------------
// z 구하는 과정에서 int범위를 벗어날 수 있으므로 주의해야함.
// max를 Integer.MAX_VAULE로 둬버려서 시간초과가 났음.
// 문제에서 주어진 x의 범위가 10억 이하이므로 수정.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 이분 탐색
		int z = (int) ((long) y * 100 / x);
		int output = -1;
		int min = 0;
		int max = 1_000_000_000;
		while(min <= max) {
			int mid = (min + max) / 2;
			if((int)((long) (y + mid) * 100 / (x + mid)) != z) { 	// 승률 변하면
				output = mid;
				max = mid - 1;										// 오른쪽 포인터 왼쪽으로 옮기기
			}
			else													// 승률 그대로면
				min = mid + 1;										// 한번더
		}
		// 출력
		System.out.print(output);
	}
}