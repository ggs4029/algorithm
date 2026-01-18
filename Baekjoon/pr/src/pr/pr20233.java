import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		int sum1 = 0;
		int sum2 = 0;
		// 월 사용료 구하기
		if(t <= 30)
			sum1 = a;
		else
			sum1 = a + (t - 30) * x * 21;
		if(t <= 45)
			sum2 = b;
		else
			sum2 = b + (t - 45) * y * 21;
		// 출력
		System.out.print(sum1 + " " + sum2);
	}
}