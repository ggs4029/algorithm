import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr24736 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력과 점수 계산
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum1 = t * 6 + f * 3 + s * 2 + p + c * 2;
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int sum2 = t * 6 + f * 3 + s * 2 + p + c * 2;
		// 출력
		System.out.print(sum1 + " " + sum2);
	}
}