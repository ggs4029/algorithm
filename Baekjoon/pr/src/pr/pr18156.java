// 백준 18156번
// 각 사각형이 검은색 또는 흰색으로 칠해진 nxn 격자에서
// 문제에서 주어진 조건을 만족하고 있는지 출력하는 문제
// 방법---------------------
// 첫째 줄에 정수 n을 입력 받고
// n줄에 걸쳐 길이가 n인 문자열들을 입력 받음.
// 각 행에 흰색 사각형의 개수와 검은색 사각형의 개수가 같은지,
// 각 열에 흰색 사각형의 수와 검은색 사각형의 수가 같은지,
// 어떤 행이나 열에도 같은 색깔의 사각형이 3개 이상 연속되어 있지 않은지
// for문을 돌며 검사하고 그리드가 맞으면 1, 틀리면 0 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[][] input = new char[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				input[i][j] = s.charAt(j);
			}
		}
		// 조건에 맞게 검사
		int sum1 = 0, sum2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 행 계산
				if(input[i][j]=='W')
					sum1++;
				else
					sum1--;
				// 열 계산
				if(input[j][i]=='W')
					sum2++;
				else
					sum2--;
				// 행 3개 연속 검사
				if (j >= 2 && input[i][j] == input[i][j - 1] && input[i][j] == input[i][j - 2]) {
                    System.out.print("0");
                    return;
                }
                // 열 3개 연속 검사
                if (j >= 2 && input[j][i] == input[j - 1][i] && input[j][i] == input[j - 2][i]) {
                    System.out.print("0");
                    return;
                }
			}
			// 행열 확인
			if(sum1!=0 || sum2!=0) {
				System.out.print("0");
				return;
			}
		}
		// 모든 조건을 만족했으면 1 출력
		System.out.print(1);
	}
}