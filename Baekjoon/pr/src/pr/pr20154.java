import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20154 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 계산
		int[] str = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3,
				1, 3, 3, 1, 2, 2, 2, 1, 2, 1,
				1, 2, 2, 2, 1 };
		int[] num = new int[input.length()];
		int output = 0;
		for(int i=0; i<num.length; i++)
			num[i] = str[input.charAt(i) - 'A'];
		for(int i=0; i<num.length; i++) {
			output += num[i];
			output %= 10;
		}
		// 출력
		if(output%2 == 0)
			System.out.print("You're the winner?");
		else
			System.out.print("I'm a winner!");
	}
}