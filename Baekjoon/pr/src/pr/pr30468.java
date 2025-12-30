import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		// 출력
		int sum = s + d + i + l;
		int a = sum;
		int output = 0;
		while(a/4 < n) {
			output++;
			a = sum + output;
		}
		// 출력
		System.out.print(output);
	}
}