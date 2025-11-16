import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2441 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 별찍기
		for(int i=0; i<n; i++) {
			for(int j=n-i; j<n; j++)
				sb.append(" ");
			for(int k=i; k<n; k++)
				sb.append("*");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}