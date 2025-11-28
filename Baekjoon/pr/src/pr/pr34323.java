import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34323 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		// 출력
		if(s*(m + 1)*(100 - n)/100 > s*m)
			System.out.print(s * m);
		else
			System.out.print(s * (m + 1) * (100 - n) / 100);
	}
}