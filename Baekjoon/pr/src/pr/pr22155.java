import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr22155 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int j=0; j<n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			// 쉬운 문제 조건 체크하고 출력
			if((i<=1 && f<=2) || (i<=2 && f<=1))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}