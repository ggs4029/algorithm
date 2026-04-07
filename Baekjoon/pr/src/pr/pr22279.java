import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr22279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		double qaly = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double q = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			// 퀄리티 구하기
			qaly += (q * y);
		}
		// 출력
		System.out.printf("%.3f", qaly);
	}
}