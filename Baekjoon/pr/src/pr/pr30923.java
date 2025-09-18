// 백준 30923번
// 3D 프린터로 뽑은 도형의 겉넓이를 구하는 문제.
// 프린터로 만든 히스토그램은 너비가 1로 동일한 막대 n개를 빈틈없이 붙인 모양.
// 방법---------------------
// 첫 줄에 히스토그램 개수 n을 입력 받음.
// 둘째 줄에 각 히스토그램의 높이들을 한 줄에 입력 받음.
// 겉넓이 구해 출력.
// 다른건 그냥 구하면 되고
// 막대들 사이의 옆넓이만 차의 절댓값으로 구하면 됨.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] print = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long front_back = 0;
		for(int i=0; i<n; i++) {
			print[i] = Integer.parseInt(st.nextToken());
			front_back += print[i];
		}
		// 겉넓이 구하기
		long output = 0;
		output = front_back * 2;								// 앞뒤 겉넓이
		output += n * 2;										// 위아래 겉넓이
		output += print[0] + print[n-1];						// 왼쪽오른쪽 겉넓이
		for(int i=0; i<n-1; i++)
			output += Math.abs(print[i] - print[i+1]);			// 기둥사이사이 옆 겉넓이
		// 출력
		System.out.print(output);
	}
}