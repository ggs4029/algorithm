import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int output = 0;
		while(true) {
			int input = Integer.parseInt(br.readLine());
			if(input == -1)
				break;
			output += input;
		}
		// 출력
		System.out.print(output);
	}
}