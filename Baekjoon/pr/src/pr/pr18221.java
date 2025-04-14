// 백준 18221번
// 성규가 교수님한테서 튈 수 있는지 구하는 문제.
// 서로 거리가 5 이상이고 성규랑 교수 사이에 다른 학생이 세명 이상 있어야함.
// 0 = 빈자리, 1 = 성규가 아닌 학생, 2 = 성규, 5 = 교수
// 방법---------------------
// 첫 줄에 n 입력 받고
// 다음 줄부터 n개 줄에 걸쳐 자리의 상태를 입력 받는다.
// 거리 5이상인지 확인하고 성규와 교수 위치로 만들어지는 직사각형 꼭짓점 구하고
// 범위 안 루프 돌며 학생있는지 확인.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18221 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n+1][n+1];
		int[] me = new int[2];												// 내 위치
		int[] pro = new int[2];												// 교수 위치
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=n; j++) {
				if(input.charAt((j-1)*2) == '1')
				    num[i][j] = 1;
				else if(input.charAt((j-1)*2) == '2') {
				    me[0] = i;
				    me[1] = j;
				}
				else if(input.charAt((j-1)*2) == '5') {
				    pro[0] = i;
				    pro[1] = j;
				}
				num[i][j] += num[i][j-1];
			}
		}
		if((me[0]-pro[0])*(me[0]-pro[0])+(me[1]-pro[1])*(me[1]-pro[1])<25){	// 거리 5 이하면
			System.out.print(0);											// 교수한테 잡힘
			return;
		}
		// 직사각형 만들기
		int p1, p2, p3, p4;													// 꼭짓점들
		if(me[0] < pro[0]) {
			p1 = me[0];
			p2 = pro[0];
		}
		else {
			p1 = pro[0];
			p2 = me[0];
		}
		if(me[1] < pro[1]) {
			p3 = me[1];
			p4 = pro[1];
		}
		else {
			p3 = pro[1];
			p4 = me[1];
		}
		int output = 0;
		for(int i=p1; i<=p2; i++)
			output += num[i][p4]-num[i][p3-1];
		// 출력
		if(output>=3)
			System.out.print(1);
		else
			System.out.print(0);
	}
}