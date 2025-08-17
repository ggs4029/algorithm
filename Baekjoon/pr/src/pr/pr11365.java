import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(true) {
			// 입력
			String input = br.readLine();
			if(input.equals("END"))
				break;
			sb.append(input);
			sb2.append(sb.reverse()).append("\n");
			sb = new StringBuilder();
		}
		// 출력
		System.out.print(sb2.toString().trim());
	}
}