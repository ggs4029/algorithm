import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		double v = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			double input = Double.parseDouble(st.nextToken()) / 100.0;
			// 방무 구하기
			v = 1 - (1 - v) * (1 - input);
			sb.append(v * 100).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}