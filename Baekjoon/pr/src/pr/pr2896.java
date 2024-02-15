// 백준 2896번
// 무알콜 칵테일
// 3가지 주스로 주어진 비율을 통해 칵테일을 만들고 남는 주스 양 구하기
// 방법-------------------------
// 첫째 줄에 오렌지, 사과, 파인애플 주스의 양 a, b, c를 입력 받고
// 그 다음줄에 칵테일을 만드는데 필요한 각 주스의 비율 i, j, k를 입력 받는다.
// 입력 받은 주스의 양을 각 비율로 나누고
// 그 몫이 제일 작은 값을 기준으로 주스를 만든 뒤
// 남은 양을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2896 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		double a, b, c, i, j, k;
		a = Double.parseDouble(st.nextToken());
		b = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		i = Double.parseDouble(st.nextToken());
		j = Double.parseDouble(st.nextToken());
		k = Double.parseDouble(st.nextToken());
		// 주스의 양을 각 비율로 나누기
		double n1 = a/i;
		double n2 = b/j;
		double n3 = c/k;
		double min;
		if(n1>n2)
			min = n2;
		else
			min = n1;
		if(min>n3)
			min = n3;
		// 출력
		String output = String.format("%.6f", (a-min*i));
		System.out.print(output+ " ");
		output = String.format("%.6f", (b-min*j));
		System.out.print(output+ " ");
		output = String.format("%.6f", (c-min*k));
		System.out.print(output);
	}
}