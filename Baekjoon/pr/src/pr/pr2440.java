import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2440 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=n; i>0; i--) {
			for(int j=i; j>0; j--)
				sb.append("*");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}