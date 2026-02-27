import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15128 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		if(input!=null && !input.isEmpty()) {
			StringTokenizer st = new StringTokenizer(input);
			long p1 = Long.parseLong(st.nextToken());
			long q1 = Long.parseLong(st.nextToken());
			long p2 = Long.parseLong(st.nextToken());
			long q2 = Long.parseLong(st.nextToken());
			// a/b 에서 a, b 구하기
			long a = p1 * p2;
			long b = 2 * q1 * q2;
			// 출력
			if(a%b == 0)
				System.out.print(1);
			else
				System.out.print(0);
		}
	}
}