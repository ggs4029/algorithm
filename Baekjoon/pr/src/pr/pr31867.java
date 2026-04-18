import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31867 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String k = br.readLine();
		// 문자열 확인
		int odd = 0;
		int even = 0;
		for(int i=0; i<n; i++) {
			int num = k.charAt(i) - '0';
			if(num%2 == 0)
				even++;
			else
				odd++;
		}
		// 출력
		if(even > odd)
			System.out.print(0);
		else if (odd > even)
			System.out.print(1);
		else
			System.out.print(-1);
	}
}