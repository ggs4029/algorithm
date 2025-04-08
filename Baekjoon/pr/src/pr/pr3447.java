import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3447 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = "";
		while((input = br.readLine()) != null){
			while(input.matches(".*BUG.*"))
				input = input.replaceAll("BUG", "");
			sb.append(input).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}