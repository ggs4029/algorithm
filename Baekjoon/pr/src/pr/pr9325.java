import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9325 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		// 입력 + 구매 가격 구하기
		for(int i=0; i<t; i++) {
			int sum = 0;
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				sum += q * p;
			}
			sum += s;
			sb.append(sum).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}