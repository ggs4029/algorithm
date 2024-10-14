// 백준 30395번
// 예환이가 이룰 수 있는 최장 스트릭을 구하는 문제
// 방법---------------------
// 첫 줄에는 문제를 풀기 위해 접속한 일 수 n이 주어지고
// 다음줄에는 날마다 푼 문제수가 공백으로 주어짐.
// 문제의 조건에 맞게 구현 후 최장 스트릭을 출력
// 주의! - 아이템 사용시 스트릭이 끊기지 않지만 스트릭이 늘어나진않음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30395 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] p = new int[n];
		for(int i=0; i<n; i++)
			p[i] = Integer.parseInt(input[i]);
		// 최장 스트릭 구하기
		int output = 0;
		int streak = 0;
		int item = 1;
		int tmp = 0;
		for(int i=0; i<n; i++) {
			// 아이템 사용 후 2일 지나면 다시 구입
			if(tmp==2) {
				item++;
				tmp = 0;
			}
			// 스트릭 계산
			if(p[i]>0) {									// 문제를 푼 경우
				streak++;
			}
			else {											// 문제를 안 푼 경우
				if(item==1) {								// 아이템 있으면
					item--;
				}
				else {										// 아이템도 없으면
					output = Math.max(streak, output);
					streak = 0;
					tmp = 0;
				}
			}
			// 아이템 없으면 날짜 세기
			if(item==0)
				tmp++;
		}
		// 출력
		System.out.print(Math.max(streak, output));
	}
}