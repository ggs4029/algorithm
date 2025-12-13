import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2442 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 별 찍기
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++)
				sb.append(" ");
			for(int j=1; j<=2*i-1; j++)
				sb.append("*");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}