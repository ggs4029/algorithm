import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr29163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 홀짝 개수 세기
		int odd = 0;
		int even = 0;
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp%2 == 1)
				odd++;
			else
				even++;
		}
		// 출력
		if(odd >= even)
			System.out.print("Sad");
		else
			System.out.print("Happy");
	}
}