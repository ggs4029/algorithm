import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20833 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 세제곱들의 합 구하기
		int output = 0;
		for(int i=1; i<=n; i++)
			output += (int) Math.pow(i, 3);
		// 출력
		System.out.print(output);
	}
}