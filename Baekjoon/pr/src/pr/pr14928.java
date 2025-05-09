import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		long output = 0;
		for(int i=0; i<input.length(); i++)
			output = (output * 10 + (input.charAt(i) - '0')) % 20_000_303;
		// 출력
		System.out.print(output);
	}
}