import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25784 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 출력
		if(a+b == c || b+c == a || c+a == b)
			System.out.print(1);
		else if(a*b == c || b*c == a || c*a == b)
			System.out.print(2);
		else
			System.out.print(3);
	}
}