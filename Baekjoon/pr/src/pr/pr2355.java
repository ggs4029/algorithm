import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2355 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		// a~b 사이의 숫자들 합 구하기
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		long output = (max * (max + 1)) / 2 - ((min - 1) * min) / 2;	// 1부터 max까지의 합에서 1부터 min-1까지의 합을 빼서 답 구하기
		// 출력
		System.out.print(output);
	}
}