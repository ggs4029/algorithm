// 백준 17392번
// 방학은 내일부터 시작이며, 오늘 인호의 기분은 0일 때, 약속을 적절히 배치하여 인호가 방학 동안 느낄 우울함의 합을 최소화해야하는 문제.
// 인호의 기분은 정수로 표현 가능하며, 기분이 0 미만인 날에 (기분)^2 만큼 우울함을 느낀다.
// 인호의 기분은 오늘 약속이 있다면 약속의 기대행복 값인 Hi이며, 약속이 없으면 어제의 기분에서 1을 뺀 값이다.
// 인호는 하루에 최대 한 개의 약속을 소화할 수 있으며, N개의 약속들의 순서는 주어진 순서대로여야 한다.
// 방법---------------------
// 첫 줄에 인호의 약속 개수 n과 방학의 일수인 m이 주어짐.
// 두번째 줄에는 n개의 약속에 대한 기대행복 값들이 주어짐.
// 최소 우울함을 구하기 위해 기분이 음수로 가는 것을 최대한 피하고
// 주어진 약속들을 최적의 방법으로 배치 할 때를 상정해서
// 우울함의 합을 구하고 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17392 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] happy = new int[n];
		for(int i=0; i<n; i++)
			happy[i] = Integer.parseInt(st.nextToken());
		// 최소 우울 구하기
		int output = 0;
		int max = n;										// 최대 행복값 저장할 변수, n은 기분이 0인 날
		for(int i=0; i<n; i++)
			max += happy[i];
		if(m <= max)										// 방학이 최대 행복값 보다 작으면
			System.out.print(0);							// 우울할 날이 없음
		else {
			int tmp = m - max;
			int tmp2 = tmp / (n + 1);  						// 반복 횟수
			for(int i=1; i<=tmp2; i++)
				output += (i*i) * (n+1);					// 우울함 더해주기
			output += (tmp2+1) * (tmp2+1) * (tmp % (n + 1));
			// 출력
			System.out.print(output);
		}
	}
}