// 백준 2025IUPC_A번
// 인경호에 도둑이 들지않게 울타리를 설치하려함.
// 인경호의 크기는 세로 n, 가로 m.
// 가장 큰 정사각형 모양으로 울타리를 설치할 때,  넓이를 구하는 문제.
// 단, 울타리는 인경호 바깥으로 나가면 안되고 인경호 전체를 감싸는 형태도 불가능함.
// 방법---------------------
// 첫 줄에 인경호의 크기 n, m을 입력 받음.
// 정사각형인 경우와 아닌 경우로 나눠 넓이 구해 출력.
// 오답노트------------------
// 정사각형인 경우에 n,m이 홀짝일 경우를 나눠서 처리했는데
// 그럴 필요가 없었음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 가장 큰 정사각형 넓이 구하기
		int output = 0;
		int tmp = Math.min(n-1, m-1);
		if(n==m) 												// 정사각형인 경우
			output = (tmp - 1) * (tmp - 1) + 1;
		else													// 정사각형이 아닌 경우
			output = tmp * tmp;
		// 출력
		System.out.print(output);
	}
}