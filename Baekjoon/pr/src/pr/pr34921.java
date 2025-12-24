import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		// 덕후력 구하기
		int p = 10 + 2 * (25 - a + t);
		// 출력
		if(p <= 0)
			System.out.print(0);
		else
			System.out.print(10 + 2 * (25 - a + t));
	}
}