import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		// 출력
		if(a>=20 && a<=23)
			System.out.print(24 - a + b);
		else
			System.out.print(b - a);
	}
}