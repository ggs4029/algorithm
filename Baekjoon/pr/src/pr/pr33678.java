// 백준 33678번
// 직장인 로마는 아이돌 콘서트 보러가려고 가능한 한 오랫동안 휴가를 다녀오고 싶어 함.
// 로마는 n일 중 한 번만 연속된 기간을 선택해 휴가 가능.
// 휴가 다녀온 후 i일에 일 하면 ai만큼 일급 받음.
// 휴가를 다녀오기 전에는 i일에 일하면 보너스가 적용되어 ai * x 만큼 일급 받음.
// 휴가 중엔 일 x, 첫날부터 휴가 가능.
// 콘서트 티켓 비용은 후불 지불 가능 -> 휴가 가기전 벌은 돈 + 갔다온 후 번 돈 <= k면 됨.
// 주어진 일 수 n, 콘서트 티켓 비용 k, 일급 보너스 x, 일급 a1, a2 ... , an 이 주어지면
// 최대 며칠 휴가를 다녀올 수 있는지 구하는 문제.
// 방법---------------------
// 첫 줄에 n, k, x가 한 줄에 주어짐.
// 둘쨰 줄에 an들이 한 줄에 주어진다.
// 이분탐색하며 휴가일수 기준으로
// for문 돌면서 휴가 시작 날짜에 따라
// 휴가 전 번 돈 + 휴가 후 번 돈이 티켓값을 넘거나 같은지 검사하고
// 조건맞으면 휴가 더 늘리고 다시 해보고
// 안맞으면 줄여서 다시하고 최종 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33678 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] money = new int[n + 1];								// n일차까지 번돈
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<=n; i++)
			money[i] = money[i - 1] + a[i - 1];
		// 이분 탐색
		int output = -1;
		int min = 1;
		int max = n - 1;
		while(min <= max) {
			int mid = (min + max) / 2;
			for(int j=0; j<=n-mid; j++) {
				if(x * money[j] + money[n] - money[j + mid] >= k) {	// 휴가 전 + 휴가 후 번 돈이 티켓값보다 많거나 같으면
					output = mid;
					min = mid + 1;
					break;
				}
				if(j == n-mid)
					max = mid - 1;									// 휴가 줄이고 다시
			}
		}
		// 출력
		System.out.print(output);
	}
}