import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(n - l * p + " ");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}