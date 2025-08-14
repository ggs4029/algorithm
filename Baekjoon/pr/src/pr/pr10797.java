import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr10797 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 10부제 검사
		int sum = 0;
		while(st.hasMoreTokens())
			if(n == Integer.parseInt(st.nextToken()))
				sum++;
		// 출력
		System.out.print(sum);
	}
}