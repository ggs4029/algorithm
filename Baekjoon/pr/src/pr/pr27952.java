// 백준 27952번
// 날짜마다 건표가 운동과 음식을 통해 체중을 줄이고 늘릴수 있음.
// 체중을 줄일 때, 루틴을 몇번이나 반복할 수 있는지 최대 횟수를 구하는 문제.
// 루틴을 진행할 때마다 몸무게가 x만큼 빠짐.
// 방법---------------------
// 첫 줄에 n과 x가 주어짐.
// 둘째 줄에 매일 최종 몸무게의 하한들이 n개 주어짐.
// 셋째 줄에 매일 늘어나는 몸무게들이 n개 주어짐.
// for문으로 배열 돌며 루틴 최대 횟수 더해가며
// 쓰러지지않는지 검사하고 최대 횟수 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27952 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());
		long[] a = new long[n];							// 최종 몸무게의 하한
		long[] b = new long[n];							// 먹고 늘어나는 몸무게
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			b[i] = Long.parseLong(st.nextToken());
		// 루틴 횟수 계산
		long tmp = 0; 									// 지금 체중
		for(int i=0; i<n; i++) {
			if(tmp+b[i] < a[i]) {						// 먹고도 하한 못넘으면
				System.out.print(-1);
				return;
			}
			tmp += b[i];
		}
		// 출력
		long output = (tmp - a[n-1]) / x;
		System.out.print(output);
	}
}