// 백준 27914번
// 앞의 학생들 중 연속한 몇 명을 골라 인터뷰를 할 때,
// 자신과 같은 학년의 학생이 한 명도 없도록 고르는 방법의 수는 몇 가지인지 구하는 문제
// 현재 급식실에 n명의 학생이 줄을 서 있고 q개의 질문을 할거임.
// 방법---------------------
// 첫 줄에 학생 수 n과 인터뷰어의 학년 k가 주어지고 질문의 수 q가 주어짐.
// 둘째 줄에는 줄을 서 있는 학생들의 학년이 주어짐.
// 셋째 줄에는 q개의 질문에 대한 정수들이 주어짐.
// 학생들의 학년을 배열에 저장 후 인터뷰어와 같은 학년만 제외하고 인터뷰 구간을 구함.
// 그 후 질문에 대한 각 구간의 카운트를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27914 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);
		long[] grade = new long[n+1];
		String[] input2 = br.readLine().split(" ");
		for(int i=1; i<=n; i++)
			grade[i] = Integer.parseInt(input2[i-1]);
		String[] input3 = br.readLine().split(" ");
		// dp
		int tmp = 0;
		if(grade[1] != k) {										// 첫번째 학생이 인터뷰어랑 다른 학년이면
			tmp++;
			grade[1] = 1;
		}
		else
			grade[1] = 0;
		for(int i=2; i<=n; i++) {
			if(grade[i] != k) {
				tmp++;
				grade[i] = grade[i-1] + tmp;
			}
			else {
				grade[i] = grade[i-1];
				tmp = 0;
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++)
			sb.append(grade[Integer.parseInt(input3[i])]).append("\n");
		System.out.print(sb.toString());
	}
}