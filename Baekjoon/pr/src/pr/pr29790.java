import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr29790 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		// 출력
		if(n >= 1000) {
			if(u>=8000 || l>=260)
				System.out.print("Very Good");
			else
				System.out.print("Good");
		}
		else
			System.out.print("Bad");
	}
}