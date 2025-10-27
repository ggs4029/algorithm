import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr26575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double d = Double.parseDouble(st.nextToken());
			double f = Double.parseDouble(st.nextToken());
			double p = Double.parseDouble(st.nextToken());
			System.out.println("$" + String.format("%.2f", d * f * p));
		}
	}
}