// 백준 17615번
// 일직선상에 놓여 있는 볼에 관한 정보가 주어질 때,
// 규칙에 따라 볼을 이동하여 같은 색끼리 모으되 최소 이동횟수를 출력하는 문제.
// 볼을 움직이는 규칙은 문제 참고.
// 방법---------------------
// 첫 줄에 볼의 개수 n이 주어짐.
// 다음 줄에 볼의 색깔들이 한 줄에 주어짐.
// 왼쪽으로 빨간, 파란볼 모으는 경우
// 오른쪽으로 빨간, 파란볼 모으는 경우 네가지 경우의 수 구해서 min값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17615 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int output = Integer.MAX_VALUE;
		// 옮겨야하는 공과 같은 색이면 sum++
		// 반대 색이면 뛰어넘을수 있으므로 true로 tmp 바꿔주기
		// 왼쪽으로 빨간볼 옮기기
		int sum = 0;
		boolean tmp = false;
		for(int i=0; i<n; i++) {
			if(tmp && input.charAt(i)=='R')
				sum++;
			if(input.charAt(i)=='B')
				tmp = true;
		}
		output = Math.min(output, sum);
		// 왼쪽으로 파란볼 옮기기
		sum = 0;
		tmp = false;
		for(int i=0;i<n;i++) {
			if(tmp && input.charAt(i)=='B')
				sum++;
			if(input.charAt(i)=='R')
				tmp = true;
		}
		output = Math.min(output, sum);
		// 오른쪽으로 빨간볼 옮기기
		sum = 0;
		tmp = false;
		for(int i=n-1; i>=0; i--) {
			if(tmp && input.charAt(i)=='R')
				sum++;
			if(input.charAt(i)=='B')
				tmp = true;
		}
		output = Math.min(output, sum);
		// 오른쪽으로 파란볼 옮기기
		sum = 0;
		tmp = false;
		for(int i=n-1; i>=0; i--) {
			if(tmp && input.charAt(i)=='B')
				sum++;
			if(input.charAt(i)=='R')
				tmp = true;
		}
		output = Math.min(output, sum);
		// 출력
		System.out.print(output);
	}
}