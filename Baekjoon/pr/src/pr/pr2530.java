import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2530 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(br.readLine());
		// 시간 계산
		c += d;
		b += (c / 60);				// 분으로 올리기
		c = c % 60;					// 초 계산
		a += (b / 60);				// 시로 올리기
		b = b % 60;					// 분 계산
		a = a % 24;					// 시 계산
		// 출력
		System.out.print(a + " " + b + " " + c);
	}
}