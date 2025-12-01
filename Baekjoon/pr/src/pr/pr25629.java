import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int odd = 0;
		int even = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(st.nextToken());
			// 홀짝 개수 세기
			if(input%2 == 1)
				odd++;
			else
				even++;
		}
		// 출력
		if(n%2 == 1) {
			if(odd-even == 1)
				System.out.print(1);
			else
				System.out.print(0);
		}
		else
			if(odd == even)
				System.out.print(1);
			else
				System.out.print(0);
	}
}