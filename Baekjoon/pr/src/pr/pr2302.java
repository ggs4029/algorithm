// 백준 2302번
// VIP 회원들의 좌석 번호들이 주어졌을 때, 사람들이 좌석에 앉는 서로 다른 방법의 가짓수를 구하는 프로그램을 작성.
// 입장권에 5번이 쓰여 있으면 5번 좌석에 앉아야 한다. 단, 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다.
// BUT vip회원들은 지정된 본인의 좌석에만 앉아야함.
// 방법---------------------
// 첫 줄에 좌석 수 n을 입력 받음.
// 둘째 줄에는 고정석(vip)의 개수 m을 입력 받음.
// 그 다음 줄부터 m줄에 걸쳐 고정석의 자리를 입력 받는다.
// vip석이 없을 때의 dp를 구하고 (피보나치)
// vip석은 고정으로 박아두고 그 앞의 의자 개수를 세어 dp[의자개수] 싹다 곱해 출력.
// 주의! - dp[0] = 1 로 해야 곱셈할 때 0이 나오는 경우가 없음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		// dp - vip 좌석이 없을 때
		long[] dp = new long[40+1];
		dp[1] = 1; dp[2] = 2; dp[0] = 1;
		for(int i=3; i<=40; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		// vip 지정석 있을 때 좌석에 앉을 수 있는 가짓수 구하기
		long output = 1;
		int vip = 0;										// 전의 vip 좌석 인덱스를 기록할 변수
		for(int i=0; i<m; i++) {
			// 입력2
			int tmp = Integer.parseInt(br.readLine());		// 입력 받은 vip 지정석 인덱스
			output = output * dp[tmp-vip-1];
			vip = tmp;
		}
		output = output * dp[n-vip];						// 마지막 vip석 ~ 마지막 자리 처리
		// 출력
		System.out.print(output);
	}
}