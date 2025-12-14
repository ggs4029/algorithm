import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		// 열개씩 출력가기
		for(int i= 0; i<input.length(); i++) {
			sb.append(input.charAt(i));
			if((i+1)%10 == 0)
				sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}