// 백준 10655번
// 마라톤 코스에 체크포인트가 n개 있음.
// 귀찮아서 체크포인트를 하나 건너뛰려는데
// 어떤 체크포인트를 건너 뛰어야 달리는 거리가 제일 짧은지 달려야하는 최소거리를 구하는 문제.
// 방법---------------------
// 첫 줄에 체크포인트의 수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 정수가 두개씩 주어짐.
// 첫 번째 정수는 체크포인트 i의 x좌표, 두 번째 정수는 y좌표.
// 그 체크포인트를 건너뛰었을 때의 이동거리와 건너뛰지않았을 때의 거리 사이의 차를 순회하면서 구하고
// 가장 큰 차를 구해 총 뛴 거리에서 빼서 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr10655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		// 체크포인트 하나 건너뛰고 달릴 때의 최소거리 구하기 
		long sum = 0;														// 총 뛴 거ㅣㄹ
		long tmp = 0;														// 건너뛴 거리의 최댓값 저장할 변수
		for(int i=1; i<n; i++)
			sum += Math.abs(x[i]-x[i-1]) + Math.abs(y[i]-y[i-1]);
		for(int i=1; i<n-1; i++) {
			long tmp1 = Math.abs(x[i]-x[i-1]) + Math.abs(y[i]-y[i-1]);		// 이전 체크포인트 ~ 지금 체크포인트
			long tmp2 = Math.abs(x[i+1]-x[i]) + Math.abs(y[i+1]-y[i]);		// 지금 체크포인트 ~ 다음 체크포인트
			long pass = Math.abs(x[i+1]-x[i-1]) + Math.abs(y[i+1]-y[i-1]);	// 이전 체크포인트 ~ 다음 체크포인트
			if(tmp < tmp1 + tmp2 - pass)
				tmp = tmp1 + tmp2 - pass;
		}
		// 출력
		System.out.print(sum - tmp);
	}
}