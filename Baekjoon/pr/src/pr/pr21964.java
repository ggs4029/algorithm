import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for(int i=n-5; i<n; i++)
			sb.append(input.charAt(i));
		// 출력
		System.out.print(sb.toString().trim());
	}
}