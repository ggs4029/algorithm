import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		// 검정 줄 최대 갯수 구하기
		long output = 0;
		if(a >= b)
			output = b;
		else if(a < b)
			output = a + 1;
		// 출력
		System.out.print(output);
	}
}