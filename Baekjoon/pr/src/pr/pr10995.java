import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10995 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 별 찍기
		for(int i=1; i<=n; i++) {
			if(i%2==1) {
				for(int j=0; j<n; j++)
					sb.append("* ");
				sb.append("\n");
			}
			else {
				for(int j=0; j<n; j++)
					sb.append(" *");
				sb.append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}