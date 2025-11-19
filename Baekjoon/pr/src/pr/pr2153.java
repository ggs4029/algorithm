import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		long sum = 0;
		for(int i=0; i<input.length(); i++) {
			int tmp = input.charAt(i);
			if(tmp >= 'a')
				sum += tmp + 1 - 'a';
			else
				sum += tmp + 27 -'A';
		}
		// 소수판별
		boolean output = false;
		for(int i=2; i<sum; i++) {
			if(sum%i == 0) {
				output = true;
				break;
			}
		}
		// 출력
		if(output)
			System.out.print("It is not a prime word.");
		else
			System.out.print("It is a prime word.");
	}
}