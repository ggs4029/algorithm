import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr5575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			// 출력
			int tmp1 = 3600 * h1 + 60 * m1 + s1;
			int tmp2 = 3600 * h2 + 60 * m2 + s2;
			tmp2 = tmp2 - tmp1;
			int h = tmp2 / 3600;
			int m = tmp2 / 60 % 60;
			int s = tmp2 % 60;
			System.out.println(h + " " + m + " " + s);
		}
	}
}