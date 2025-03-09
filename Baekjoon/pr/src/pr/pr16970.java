// 백준 16970번
// 2차원 좌표 평면 위에서 두 점을 골라 선분을 그었을 때, 지나가는 점의 개수가 k개인 선분 수 구하기.
// 가능한 점의 좌표 x,y 는 0이상인 정수임.
// 그리고 x<=n y<=m임.
// 방법---------------------
// 첫 줄에 n, m k가 주어짐.
// 임의의 점(i,j)랑 점(x,y)를 문제 조건을 만족하며 순회하면서
// 점 개수 k인지 검사하고 맞으면 output++ 해서 결과 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16970 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 점 개수 세기
		int output = 0;
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				for(int x=0; x<=n; x++) {
					for(int y=0; y<=m; y++) {
						if(gcd(Math.abs(i-x), Math.abs(j-y))+1 == k)
							output++;
					}
				}
			}
		}
		// 출력
		System.out.print(output/2);
	}

	// 최대공약수 구하기 - 유클리드 호제법
	public static int gcd(int a, int b) {
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
}