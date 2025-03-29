import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5341 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			// 블록 개수 구하기
			int sum = 0;
			for(int i=1; i<=n; i++)
				sum += i;
			sb.append(sum).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());

	}
}