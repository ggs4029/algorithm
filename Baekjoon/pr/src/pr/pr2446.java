import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 별찍기
		// 윗부분
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++)
				sb.append(" ");
			for(int j=0; j<(2*n-1) - 2*i; j++)
				sb.append("*");
			sb.append("\n");
		}
		// 아랫부분
		for(int i=0; i<n-1; i++) {
			for(int j=1; j<n-1-i; j++)
				sb.append(" ");
			for(int j=0; j<2*i+3; j++)
				sb.append("*");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}