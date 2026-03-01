import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// a랑 b로 c를 만들 수 있는 경우
		if(a+b == c)
			System.out.print(a + "+" + b + "=" + c);
		else if(a-b == c)
			System.out.print(a + "-" + b + "=" + c);
		else if(a*b == c)
			System.out.print(a + "*" + b + "=" + c);
		else if(a/b==c && a%b==0)
			System.out.print(a + "/" + b + "=" + c);
		// b랑 c로 a를 만들 수 있는 경우
		else if(b+c == a)
			System.out.print(a + "=" + b + "+" + c);
		else if(b-c == a)
			System.out.print(a + "=" + b + "-" + c);
		else if(b*c == a)
			System.out.print(a + "=" + b + "*" + c);
		else if(b/c==a && b%c==0)
			System.out.print(a + "=" + b + "/" + c);
	}
}