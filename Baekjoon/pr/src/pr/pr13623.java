import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 출력
		if(b==c && b!=a)
			System.out.print("A");
		else if(a==c && a!=b)
			System.out.print("B");
		else if(a==b && a!=c)
			System.out.print("C");
		else
			System.out.print("*");
	}
}