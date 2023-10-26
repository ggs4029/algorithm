// 백준 2033번
// 입력 받은 수를 맨 아랫자리부터 반올림하기
// 방법--------------------
// 수를 입력 받고
// 한자리 수라면 그냥 출력한다.
// 두자리 수 이상이라면 for문을 통해
// 반올림을 계속한다.
// 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2033 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split("");
		// 반올림
		if(input.length==1) // 한자리 수 정수를 입력 받은 것이라면 그냥 출력
			System.out.print(input[0]);
		else {
			for(int x=input.length-1; x>=1; x--) {
				if(Integer.parseInt(input[x])>=5) { // 5 이상이면
					input[x] = "0";
					input[x-1] = Integer.toString(Integer.parseInt(input[x-1])+1);
				}
				else { // 5 미만이라면
					input[x] = "0";
				}
			}
			// 출력
			for(String s : input) {
				System.out.print(s);
			}
		}
	}
}