import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 출력
		if(a==b && b==c)
			System.out.print("2");
		else if(a>b && b>c && a*a == b*b + c*c || a>c && c>b && a*a == c*c + b*b || b>a && a>c && b*b == a*a + c*c || b>c && c>a && b*b == c*c + a*a || c>a && a>b && c*c == a*a + b*b || c>b && b>a && c*c == b*b + a*a)
			System.out.print("1");
		else
			System.out.print("0");
	}
}