import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double n = Double.parseDouble(st.nextToken());
		double m = Double.parseDouble(st.nextToken());
		// 출력
		System.out.print((int)Math.ceil(n/m));
	}
}