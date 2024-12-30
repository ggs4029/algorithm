// 백준 30022번
// 동하가 상점 1에서 a개의 물건을, 지원이가 상점 2에서 b개의 물건을 구입해서
// n종류의 물건을 모두 구매하는 데 필요한 최소 비용을 구하는 문제.
// 방법---------------------
// 첫 줄에 정수 n과 a, b를 입력 받는다.
// 둘째 줄부터 n줄에 걸쳐 정수 두개를 입력 받는다.
// 이 정수 둘은 상점 1, 2에서 i번째 물건을 판매하는 가격을 의미.
// 순서가 같은 물건들의 가격 차이를 기준으로 오름차순 정렬하고
// a번 상점 1에서 사고 나머지는 상점 2에서 사서 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class pr30022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int a = Integer.parseInt(input[1]);
		int b = Integer.parseInt(input[2]);
		int[][] price = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] input2 = br.readLine().split(" ");
			price[i][0] = Integer.parseInt(input2[0]);
			price[i][1] = Integer.parseInt(input2[1]);
		}
		// 정렬
		Arrays.sort(price, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return (x[0] - x[1]) - (y[0] - y[1]);
            }
        });
		// 상품 구입
		long output = 0;
		for(int i=0; i<a; i++)
			output += price[i][0];
		for(int i=a; i<n; i++)
			output += price[i][1];
		// 출력
		System.out.print(output);
	}
}