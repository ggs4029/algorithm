import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32498 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 판별
		int sum = 0;
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a%2 == 1)
				sum++;
		}
		// 출력
		System.out.print(sum);
	}
}