import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr35479 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double r = Double.parseDouble(st.nextToken());
		double g = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		// r' g' b' 구하기
		double r1 = r / 255.0;
		double g1 = g / 255.0;
		double b1 = b / 255.0;
		// k 구하기
		double max = Math.max(r1, Math.max(g1, b1));
		double k = 1 - max;
		double c, m, y;
		// cmyk 값 구하기
		if(k == 1) {
			c = 0;
			m = 0;
			y = 0;
		}
		else {
			c = (1 - r1 - k) / (1 - k);
			m = (1 - g1 - k) / (1 - k);
			y = (1 - b1 - k) / (1 - k);
		}
		// 출력
		System.out.print(c + " " + m + " " + y + " " + k);
	}
}