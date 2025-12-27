import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30868 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			// 칠판에 그리기
			for(int j=0; j<n/5; j++)
				sb.append("++++ ");
			for(int j=0; j<n%5; j++)
				sb.append("|");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}