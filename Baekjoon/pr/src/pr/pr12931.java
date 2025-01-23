// 백준 12931번
// 1.배열에 있는 값 하나를 1 증가시킨다.
// 2. 배열에 있는 모든 값을 두 배 시킨다.
// 모든 값이 0으로 채워져 있는 길이가 N인 배열 A를 배열 B로 만들기 위한 연산의 최소 횟수를 구하는 문제.
// 연산은 한번에 위에 두가지 중 하나만 가능.
// 방법---------------------
// 첫 줄에 배열의 크기 n이 주어짐.
// 다음 줄에 배열 b가 주어짐.
// 배열b의 요소들을 전부 0으로 만드는 식으로 풀이.
// 1번 연산을 통해 요소들을 전부 짝수로 만들고
// 2번 연산 실행.
// 연산 횟수 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr12931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum += num[i];
		}
		// 연산 최소 횟수 구하기
		int output = 0;
		while(sum > 0) {
			int tmp = 0;						// 1번 연산이 몇번 일어났는지 저장할 변수
			// 홀수 처리
			for(int i=0; i<n; i++) {
				if(num[i]%2 == 1) {
					tmp++;
					num[i]--;
				}
			}
			//
			if(tmp > 0) {						// 연산 수만큼
				sum -= tmp;
				output += tmp;
			}
			// 짝수 처리
			else {
				for(int i=0; i<n; i++)
					num[i] /= 2;
				sum /= 2;
				output++;
			}
		}
		// 출력
		System.out.print(output);
	}
}