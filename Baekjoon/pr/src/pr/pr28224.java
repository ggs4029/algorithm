import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 + 가격 구하기
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += Integer.parseInt(br.readLine());
		// 출력
		System.out.print(sum);
	}
}