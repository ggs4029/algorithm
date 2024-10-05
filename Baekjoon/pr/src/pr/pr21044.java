// 백준 21044번
// Inverse Common Superstring
// 방법---------------------
// 첫 줄에 문자열 R을 입력 받음.
// a가 연속해서 나온만큼의 + 1 만큼 a 출력
// 주의! - 마지막에 a가 연속으로 나오는 경우 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21044 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String R = br.readLine();
		int sum = 0;
		int tmp = 0;
		for(int i=0; i<R.length(); i++) {
			if(R.charAt(i)=='a') {
				tmp++;
			}
			else {
				if(sum<tmp)
					sum = tmp;
				tmp = 0;
			}
		}
		// 마지막에 a가 연속으로 나오는 경우
		if(sum<tmp)
			sum = tmp;
		// 출력
		for(int i=0; i<sum+1; i++)
			System.out.print("a");
	}
}