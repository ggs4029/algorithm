import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		String s = br.readLine();
		// 개수 세기
		int l = input.length();
		input = input.replace(s, "");
		// 출력
		System.out.print((l - input.length()) / s.length());
	}
}