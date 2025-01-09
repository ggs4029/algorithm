// 백준 12865번
// 로봇을 만들던 중에 구멍을 막을 두 레고 조각이 필요하다는 것을 깨달았다.
// 구멍의 너비는 x 센티미터이고, 구멍에 넣을 두 조각의 길이의 합은 구멍의 너비와 정확하게 일치해야 함.
// 구멍은 항상 두 조각으로 막아야 한다.
// 지난밤, 상근이와 선영이는 물리 실험실에 들어가서 레고 조각의 크기를 모두 정확하게 재고 돌아왔다.
// 구멍을 완벽하게 막을 수 있는 두 조각을 구하는 문제.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스로 이뤄져 있고,
// 각 테스트 케이스는 첫 줄에 구멍의 너비 x를 입력 받고
// 다음 줄에는 레고 조각의 수 n을 입력 받음.
// 그 다음 줄부터 n줄에 걸쳐 레고 조각의 길이들을 한 줄에 하나씩 입력 받음.
// 입력 받은 레고조각들 정렬해주고 이분탐색 시작.
// 정답이 여러 개인 경우 두 레고 조각의 차의 절댓값을 출력해라 = 이분탐색으로 나온 첫 답이 정답.
// 정답 출력 or danger 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr3649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder();
			// 입력
			int x = Integer.parseInt(input);
			int n = Integer.parseInt(br.readLine());
			long[] lego = new long[n];
			for(int i=0; i<n; i++)
				lego[i] = Long.parseLong(br.readLine());
			// 정렬
			Arrays.sort(lego);
			// 이분 탐색
			int left = 0, right = n-1;
			while(left<right) {
				long tmp = lego[left]+lego[right];
				if(tmp == 10_000_000 * (long) x) {										// 구멍 크기 맞으면
					sb.append("yes " + lego[left] + " " + lego[right]).append("\n");	// 답 넣고 break
					break;
				}
				else if(tmp < 10_000_000 * (long) x)										// 구멍보다 작으면
					left++;																// 왼쪽 +
				else																	// 구멍보다 크면
					right--;															// 오른쪽 -
			}
			if(sb.length() == 0)														// 비어있으면
				sb.append("danger").append("\n");										// 맞는 구멍x
			// 출력
			System.out.println(sb.toString().trim());
		}
	}
}