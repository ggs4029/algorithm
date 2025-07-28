import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int e1 = Integer.parseInt(st.nextToken());
		int f1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int t2 = Integer.parseInt(st.nextToken());
		int e2 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		// 점수 구하기
		int sum1 = t1 * 3 + e1 * 20 + f1 * 120;
		int sum2 = t2 * 3 + e2 * 20 + f2 * 120;
		// 출력
		if(sum1 > sum2)
			System.out.print("Max");
		else if(sum1 < sum2)
			System.out.print("Mel");
		else if(sum1 == sum2)
			System.out.print("Draw");
	}
}