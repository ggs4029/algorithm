import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr4299 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// 출력
		if(a < b)
			System.out.print("-1");
		else{
			int x = (a+b) / 2;
			int y = (a-b) / 2;
			if(x+y == a && x-y == b)
				System.out.print(x + " " + y);
			else
				System.out.print("-1");
		}
	}
}