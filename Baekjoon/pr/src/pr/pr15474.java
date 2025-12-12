import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15474 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		// 세트 구입 비용 구하기
		int x = 0;
		int y = 0;
		if(n%a == 0)
			x = (n / a) * b;
		else
			x = (n / a + 1) * b;
		if(n%c == 0)
			y = (n / c) * d;
		else
			y = (n / c + 1) * d;
		// 출력
		if(x > y)
			System.out.print(y);
		else
			System.out.print(x);
	}
}