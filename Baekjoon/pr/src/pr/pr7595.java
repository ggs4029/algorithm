import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr7595 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			for(int i=1; i<=n; i++) {
				for(int j=0; j<i; j++)
					sb.append("*");
				sb.append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}