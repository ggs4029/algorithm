// 백준 10813번
// n과 m을 입력 받음
// i j k 를 m번 입력받음
// 1차원 배열의 길이는 n이 될 것임 and 바구니의 번호로 값을 초기화
// i j 를 입력 받을 때마다 그 자리의 값을 서로 바꿈

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n과 m 입력 받기
		String[] firstLn = br.readLine().split(" ");
		int n = Integer.parseInt(firstLn[0]);
		int m = Integer.parseInt(firstLn[1]);
		// 배열 생성과 초기화
		int[] basket = new int[n];
		for (int x = 0; x < basket.length; x++)
			basket[x] = x+1;
		// i j 입력 받기
		for (int x = 0; x < m; x++) {
			String[] secondLn = br.readLine().split(" ");
			int i = Integer.parseInt(secondLn[0]);
			int j = Integer.parseInt(secondLn[1]);
			// 공넣기
			int num = basket[i-1];
			basket[i-1] = basket[j-1];
			basket[j-1] = num;
		}
		// 최종출력
		for (int x = 0; x < basket.length; x++)
			System.out.print(basket[x] + " ");
	}

}
