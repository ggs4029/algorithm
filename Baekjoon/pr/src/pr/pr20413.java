// 백준 20413번
// mvp등급으로 과금액 역추적하기
// 방법---------------------
// 첫 줄에 게임을 플레이 한 개월수 N을 입력 받고
// 다음 줄에 실 골 플 다 등급 기준액 s g p d를 입력 받음
// 다음 줄에는 게임을 플레이 한 첫번째 달부터 마지막까지 mvp 등급이 주어짐.
// 그리디 알고리즘 사용
// 다음달 등급에 주의하며 가능한 한 매 달 최대 과금액을 할당하고 전체 과금액에 더함.
// 주의! - 이번달 과금액이 음수가 되는 경우 저번달의 과금액을 줄이고 이번달의 과금액을 0으로 설정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		String mvp = br.readLine();
		// 등급별 기준액 설정 (브실골플다)
		int[] grade = new int[5];
		grade[0] = 0;								// 브론즈(0) - 0원
		for(int i=1; i<5; i++)						// 실골플다(1~4)
			grade[i] = Integer.parseInt(input[i-1]);
		// 과금액 역추적
		int[] cash = new int[N+1];
		int sum = 0;								// 총 과금액(최대)
		for(int i=0; i<N; i++) {
			int tmp;
			if(mvp.charAt(i)=='B')
				tmp = grade[1];
			else if(mvp.charAt(i)=='S')
				tmp = grade[2];
			else if(mvp.charAt(i)=='G')
				tmp = grade[3];
			else									// P or D
				tmp = grade[4];
			// 이번달 과금액 계산
			if(mvp.charAt(i)=='D')
				cash[i+1] = grade[4];
			else
				cash[i+1] = tmp - 1 - cash[i];
			// 이번달 과금액이 음수인 경우
			if(cash[i+1]<0) {
				cash[i] = tmp - 1;					// 저번달 과금액을 다음 등급 기준액 -1로
				cash[i+1] = 0;						// 이번달 과금액 0
			}
		}
		// 출력
		for(int i=1; i<=N; i++)
			sum += cash[i];
		System.out.print(sum);
	}
}