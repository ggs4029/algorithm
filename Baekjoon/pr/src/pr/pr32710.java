import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32710 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 구구단에 나오는지 확인하기
		int output = 0;
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(n==i || n==j || n==i*j) {
					output = 1;
					break;
				}
			}
			if(output == 1)
				break;
		}
		// 출력
		System.out.print(output);
	}
}