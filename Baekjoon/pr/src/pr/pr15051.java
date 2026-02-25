import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a1 = Integer.parseInt(br.readLine());
		int a2 = Integer.parseInt(br.readLine());
		int a3 = Integer.parseInt(br.readLine());
		// 시간 최솟값 구하기
		int f1 = a2 * 2 + a3 * 4;
		int f2 = a1 * 2 + a3 * 2;
		int f3 = a1 * 4 + a2 * 2;
		// 출력
		System.out.print(Math.min(f1, Math.min(f2, f3)));
	}
}