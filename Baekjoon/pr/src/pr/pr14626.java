import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr14626 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		char[] isbn = br.readLine().toCharArray();
		// 가중치 더하기
		int output = 0;
		int idx = 0;
		for(int i=0; i<=12; i++) {
			if(isbn[i] == '*') {
				idx = i;
				continue;
			}
			if(i%2 == 0)								// 짝이면 가중치 1
				output += isbn[i] - '0';
			else										// 홀이면	3
				output += (isbn[i] - '0') * 3;
		}
		// 훼손된 숫자 찾아 출력
		for(int i=0; i<10; i++) {
			if(idx%2 == 0) {
				if((output + i)%10 == 0) {
					System.out.print(i);
					return;
				}
			}
			else {
				if((output + 3 * i)%10 == 0) {
					System.out.print(i);
					return;
				}
			}
		}
	}
}