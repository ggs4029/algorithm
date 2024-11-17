// 백준 17262번
// 욱제가 학교에 머무르는 최소의 시간을 계산하는 문제.
// 방법---------------------
// 첫 줄에 욱제의 팬의 수 n이 주어짐.
// 둘째 줄부터 n줄에 걸쳐 팬들이 학교에 머무르는 시간을 입력 받음.
// 가장 빨리 집가는 애랑 가장 늦게 학교 오는애 시간 구해서 비교 and 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17262 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int x = 0;
		int y = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			// 최소 시간 구하기
			if(b<y)
				y = b;
			if(a>x)
				x = a;
		}
		// 출력
		if(x-y<0)
			System.out.print(0);
		else
			System.out.print(x-y);
	}
}