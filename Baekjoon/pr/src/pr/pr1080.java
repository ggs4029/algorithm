// 백준 1080번
// 0과 1로만 이루어진 행렬 A와 행렬 B가 있다.
// 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 문제.
// 행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것. (0은 1로, 1은 0으로)
// 방법---------------------
// 첫 줄에 행렬 크기 n, m이 주어짐.
// 둘째 줄부터 n개 줄에 행렬 a가 주어지고 그 다음에 n개 줄에 행렬 b가 주어짐.
// 한칸씩 비교해가며 같은 값인지 비교하고 다른 값이면 그 칸을 왼쪽 끝으로 하는 3x3 뒤집기 연산을 진행한다.
// 필요한 연산 수를 구하고 마지막에 두 행렬이 같은지 비교해 알맞은 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		char[][] matrix1 = new char[n][m];
		char[][] matrix2 = new char[n][m];
		for(int i=0; i<n; i++){
			String input2 = br.readLine();
			matrix1[i] = input2.toCharArray();
		}
		for(int i=0; i<n; i++){
			String input2 = br.readLine();
			matrix2[i] = input2.toCharArray();
		}
		// 필요한 연산 횟수 구하기
		int output = 0;
		for(int i=0; i<n-2; i++){
			for(int j=0; j<m-2 ; j++){
				if(matrix1[i][j]==matrix2[i][j])							// 비교해서 같은 값이면 스킵
					continue;
				output++;													// 아니면 뒤집기 연산
				for(int x=i; x<i+3; x++){									// 3x3 뒤집기
					for(int y=j; y<j+3; y++){
						if(matrix1[x][y]=='1')
							matrix1[x][y]='0';
						else
							matrix1[x][y] = '1';
					}
				}
			}
		}
		// 뒤집기 다 끝내고 두 행렬이 같은지 비교 + 출력
		for(int i=0; i<n; i++){
			for(int j=0; j<m ; j++){
				if(matrix1[i][j]!=matrix2[i][j]){
					System.out.print(-1);
					return;
				}
			}
		}
		System.out.print(output);
	}
}