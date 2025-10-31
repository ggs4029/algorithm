import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8710 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = (w - k) / m;
		if((w - k) % m != 0)
			count++;
		// 출력
		System.out.print(count);
	}
}