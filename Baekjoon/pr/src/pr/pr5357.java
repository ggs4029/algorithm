import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			sb.append(input.charAt(0));
			// 중복 체크
			for(int j=1; j<input.length(); j++) {
				if(input.charAt(j) != input.charAt(j - 1))
					sb.append(input.charAt(j));
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}