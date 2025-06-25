import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26545 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 합 구하기
		long sum = 0;
		for(int i=0; i<n; i++)
			sum += Integer.parseInt(br.readLine());
		// 출력
		System.out.print(sum);
	}
}