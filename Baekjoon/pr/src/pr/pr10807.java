// 백준 10807번
// 입력받을 정수의 개수를 입력받고
// 개수만큼의 정수를 다시 입력받고
// 입력받은 정수들중 찾으려고하는 정수를 입력받는다
// 그리고 그 정수가 몇개인지 출력함

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10807 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] test = new int[num];

		String[] test2 = br.readLine().split(" ");
		for (int x = 0; x < num; x++) {
			test[x] = Integer.parseInt(test2[x]);
		}

		int num2 = Integer.parseInt(br.readLine());
		int sum = 0;
		for(Integer e : test) {
			if(e==num2)
				sum++;
		}
		System.out.print(sum);
	}
}
