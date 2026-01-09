import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] menu = new int[n];
		for(int i=0; i<n; i++)
			menu[i] = Integer.parseInt(br.readLine());
		// 가격 계산
		int m = Integer.parseInt(br.readLine());
		long sum = 0;
		for(int i=0; i<m; i++)
			sum += menu[Integer.parseInt(br.readLine())-1];
		// 출력
		System.out.print(sum);
	}
}