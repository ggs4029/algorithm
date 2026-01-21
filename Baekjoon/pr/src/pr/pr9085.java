import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력 + 합 구하기
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j=0; j<n; j++)
				sum += Integer.parseInt(st.nextToken());
			sb.append(sum).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}