import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// 계산
		int sum = 0;
		for(int i=1; i<=n; i++)
			sum += i;
		int sum2 = 0;
		for(int i=1; i<=n; i++)
			sum2 += i * i * i;
		// 출력
		System.out.println(sum);
		System.out.println(sum * sum);
		System.out.print(sum2);
	}
}