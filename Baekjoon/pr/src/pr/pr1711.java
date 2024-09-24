// 백준 1711번
// 2차원 평면에 N개의 점이 주어졌을때
// 세 점을 골라 직각삼각형이 되는 경우가 몇개인지 출력하는 문제
// 방법---------------------
// 첫째 줄에 점의 개수 n을 입력 받음.
// 둘째 줄부터 n줄에 걸쳐 점의 좌표들을 입력 받음.
// 피타고라스의 정리를 이용해 삼중for문을 돌며 직각삼각형인지 검사
// 결과를 출력
// 주의! - 자료형 long으로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1711 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] x = new long[n];
		long[] y = new long[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		// 직각삼각형 검사
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					// 피타고라스의 정리
					long a = (x[i]-x[j]) * (x[i]-x[j]) + (y[i]-y[j]) * (y[i]-y[j]);
					long b = (x[i]-x[k]) * (x[i]-x[k]) + (y[i]-y[k]) * (y[i]-y[k]);
					long c = (x[j]-x[k]) * (x[j]-x[k]) + (y[j]-y[k]) * (y[j]-y[k]);
					if(a+b==c || a+c==b || b+c==a)
						sum++;
				}
			}
		}
		// 출력
		System.out.print(sum);
	}
}