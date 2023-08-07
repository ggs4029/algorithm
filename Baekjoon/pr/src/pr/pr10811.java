// 백준 10811번
// 바구니 뒤집기
// 방법----------------------
// n개의 바구니와 m번 바구니의 순서를 역순으로 만들려함
// 이를 입력받음
// for문으로 1차원 배열을 만들고 순서대로 초기화
// i번부터 j번까지의 바구니를 역순으로 만들어야함
// for문을 m번 돌며 i와 j를 입력받고
// 그 안에서 또 for문을 돌며 바구니를 역순으로 만들어야함

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10811 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n과 m을 입력받음, 1차원배열 생성과 초기화
		String[] arr1 = br.readLine().split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		int[] basket = new int[n];
		for(int x=0; x<basket.length; x++)
			basket[x] = x+1;
		// i와 j를 입력받고 영역 내의 바구니의 순서를 역순으로 만든다
		for(int x=0; x<m; x++) {
			String[] arr2 = br.readLine().split(" ");
			int i = Integer.parseInt(arr2[0]);
			int j = Integer.parseInt(arr2[1]);
			for(int y=i-1; y<=j-1; y++) {
				int a = --j;
				int b = basket[y];
				basket[y] = basket[a];
				basket[a] = b;
			}
		}
		// 최종출력
		for(int x=0; x<basket.length; x++)
			System.out.print(basket[x]+" ");
	}

}
