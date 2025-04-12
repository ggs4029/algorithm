import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int l = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		// 날짜 구하기
		int korean = 0;
		int math = 0;
		if(a % c != 0)
			korean = a / c + 1;
		else
			korean = a / c;
		if(b % d != 0)
			math = b / d + 1;
		else
			math = b / d;
		// 출력
		if(korean > math)
			System.out.print(l - korean);
		else
			System.out.print(l - math);
	}
}