// 백준 32765번
// 모든 사원은 자신보다 사원 번호가 1 큰 사원의 직속 부하인 회사에서 연봉 협상을 할거임.
// 0번 사원을 제외한 모든 사원이 다음과 같이 요구함.
// "적어도 제 부하보다는 연봉을 더 받고 싶어요. 또, 제가 받는 연봉이 제 사원 번호의 배수이면 좋겠어요."
// 최대한 돈을 아끼면서 연봉을 주려고 하고, 0번 사원의 연봉이 x일 때, q개의 질문(어떤 사원의 연봉)에 대해 답하는 문제.
// 방법---------------------
// 첫 줄에 0번 사원의 연봉 x를 입력 받고
// 두번째 줄에 쿼리의 개수 q를 입력 받는다.
// 연봉을 조건에 맞게 구해 출력한다.
// 배열 크기에 주의 - 사원번호 10만번 이후로 연봉 증가율은 같음을 활용해 해결.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32765 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		long x = Long.parseLong(input[0]);
		long q = Long.parseLong(input[1]);
		// 연봉 구하기
		long[] salary = new long[100_001];
		salary[1] = x + 1;										// 사원번호 1번의 연봉
		for(int i=2; i<=100_000; i++)
			salary[i] = salary[i-1] + (i - salary[(i-1)] % i);	// 연봉을 전번 사원보다는 크고 + i의 배수로 설정
		// 쿼리 처리
		long tmp = salary[100_000] - salary[99999];
		for(int i=0; i<q; i++) {
			long input2 = Long.parseLong(br.readLine());
			if(input2<=100_000)
				sb.append(salary[(int) input2]).append("\n");
			else												// 사원번호가 10만 이후면
				sb.append(salary[100_000] + 					// tmp만큼의 일정한 증가율을 가지며 증가함.
						(input2 - 100_000) * tmp).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}