import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 치킨 계산
		int output = 0;
		if(a >= n)
			output += n;
		else
			output += a;
		if(b >= n)
			output += n;
		else
			output += b;
		if(c >= n)
			output += n;
		else
			output += c;
		// 출력
		System.out.print(output);
	}
}