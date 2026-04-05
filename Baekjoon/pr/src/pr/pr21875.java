import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String a = br.readLine();
		String b = br.readLine();
		// 거리 구하기
		int x1 = a.charAt(0) - 'a' + 1;
		int y1 = a.charAt(1) - '0';
		int x2 = b.charAt(0) - 'a' + 1;
		int y2 = b.charAt(1) - '0';
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		// 출력
		System.out.print(Math.min(x, y) + " " + Math.max(x, y));
	}
}