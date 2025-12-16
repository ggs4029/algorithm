import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 원래 문장 구하기
		input = input.replace("apa", "a");
		input = input.replace("epe", "e");
		input = input.replace("ipi", "i");
		input = input.replace("opo", "o");
		input = input.replace("upu", "u");
		// 출력
		System.out.print(input);
	}
}