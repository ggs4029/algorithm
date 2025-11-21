import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr28281 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] price = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			price[i] = Integer.parseInt(st.nextToken());
		// 가격 구하기
		int[] money = new int [n - 1];
		for(int i=0; i<n-1; i++)
			money[i] = price[i] + price[i + 1];
		// 정렬
		Arrays.sort(money);
		// 출력
		System.out.print(money[0] * x);
	}
}