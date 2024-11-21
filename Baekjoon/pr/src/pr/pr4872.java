// 백준 11689번
// D개의 번호가 매겨진 바퀴들이 있으며, 각 바퀴는 0부터 9까지의 숫자로 표시되어 있습니다.
// 이것은 마치 가방 잠금 장치에서 보는 것과 비슷합니다.
// 그 아래에는 B개의 버튼이 있으며, 각 버튼은 D자리 숫자로 레이블이 붙어 있습니다.
// 예를 들어, D가 4이면 레이블은 1000, 1200, 1002, 0111, 0100 등이 될 수 있습니다.
// 버튼 레이블이 1000인 버튼을 누르면 첫 번째 바퀴가 한 번 돌아가지만, 나머지 바퀴는 그대로 유지됩니다.
// 버튼 레이블이 1002인 버튼을 누르면 첫 번째 바퀴는 한 번 돌고, 네 번째 바퀴는 두 번 돌아갑니다.
// 당신의 작업은 이러한 잠금된 스피너 퍼즐을 시뮬레이션하여 바퀴의 최종 상태를 출력하는 것.
// 방법---------------------
// 첫 줄이 바퀴의 초기 위치.
// 그 다음줄부턴 레이블.
// for문 돌려가며 바퀴 수만큼 돌려가며 최종 상태를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String s = br.readLine();
		int l = s.length();
		int[] wheel = new int[l];
		for(int i=0; i<l; i++)
			wheel[i] = s.charAt(i)-'0';
		// 바퀴 돌리기
		String input;
		while((input = br.readLine()) != null && !input.trim().isEmpty()) {
			for(int i=0; i<l; i++) {
				int tmp = input.charAt(i) -'0';
				wheel[i] = (wheel[i] + tmp) % 10;
			}
		}
		// 출력
		for(int i=0; i<l; i++)
			System.out.print(wheel[i]);
	}
}