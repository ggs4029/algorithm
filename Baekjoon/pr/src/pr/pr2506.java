// 백준 2506번
// 점수 계산하기
// 방법---------------------
// 한 문제를 맞을 때마다 1점, 연속으로 맞을시 1점, 2점, 3점 ...
// 첫째 줄에 문제의 개수 n을 입력 받고
// 둘째 줄에 채점 결과를 입력 받는다.
// 채점 결과를 토대로 for문을 돌며 점수를 계산한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] answer = new int[n];
		for(int x=0; x<answer.length; x++)
			answer[x] = Integer.parseInt(input[x]);
		// 점수 계산
		int sum = 0;
		int score = 1;
		for(int x=0; x<answer.length; x++) {
			if(answer[x]==1) { // 정답이면 sum에 넣고 ++
				sum += score;
				++score;
			}
			else { // 틀리면 점수 리셋
				score = 1;
			}
		}
		// 최종 출력
		System.out.print(sum);
	}
}