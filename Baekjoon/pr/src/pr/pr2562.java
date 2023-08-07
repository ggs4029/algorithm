// 백준 2562번
// 9개의 서로 다른 자연수에서
// 최댓값을 찾고 그 최댓값의 위치도 출력

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] test = new int[9];
		for(int x=0; x<9; x++) {
			test[x] = Integer.parseInt(br.readLine());
		}

		int compare = 0; // 자연수만 입력받으므로 0으로 해도된다
		for(int x=0; x<9; x++) {
			if(test[x]>compare)
				compare = test[x];
		}
		System.out.println(compare);

		for(int x=0; x<9; x++) {
			if(test[x]==compare)
				System.out.print(x+1);
		}
	}
}
