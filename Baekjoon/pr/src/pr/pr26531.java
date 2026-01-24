import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr26531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		st.nextToken();
		int c = Integer.parseInt(st.nextToken());
		// 출력
		if(a+b == c)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}