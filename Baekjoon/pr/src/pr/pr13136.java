import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13136 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long r = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		// cctv 개수 구하기
		long x = 0;									// 가로
		long y = 0;									// 세로
		if(c%n > 0)
			x = c / n + 1;
		else
			x = c / n;
		if(r%n > 0)
			y = r / n + 1;
		else
			y = r / n;
		// 출력
		System.out.print(x * y);
	}
}