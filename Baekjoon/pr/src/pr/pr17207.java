// 백준 17207번
// 5명중 가장 일이 바쁘지 않은 사람을 구하는 문제
// 방법---------------------
// 5x5 행렬a를 5줄에 걸쳐 입력 받음.
// 5x5 행렬b를 5줄에 걸쳐 입력 받음.
// 문제의 조건에 맞게 3중for문을 돌며 일량을 구하고
// 가장 안바쁜사람을 찾아 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17207 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long[][] a = new long[5][5];							// 예상한 일의 난이도
		long[][] b = new long[5][5];							// 각 일의 처리시간
		for(int i=0; i<10; i++) {
			String[] input = br.readLine().split(" ");
			if(i<5) {
				for(int j=0; j<5; j++)
					a[i][j] = Integer.parseInt(input[j]);
			}
			else {
				for(int j=0; j<5; j++)
					b[i-5][j] = Integer.parseInt(input[j]);
			}
		}
		// 일량 구하기
		long[] sum = new long[5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				int tmp = 0;
				for(int k=0; k<5; k++) {
					tmp += a[i][k] * b[k][j];
				}
				sum[i] += tmp;
			}
		}
		// 가장 안바쁜사람 찾기
		long tired = sum[0];
		int output = 0;
		for(int i=0; i<5; i++) {
			if(sum[i]<=tired) {
				tired = sum[i];
				output = i;
			}
		}
		// 출력
		if(output==0)
			System.out.print("Inseo");
		else if(output==1)
			System.out.print("Junsuk");
		else if(output==2)
			System.out.print("Jungwoo");
		else if(output==3)
			System.out.print("Jinwoo");
		else
			System.out.print("Youngki");
	}
}