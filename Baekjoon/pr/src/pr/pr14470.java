import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		// 몇 초 걸리는지 계산
		int output = 0;
		if(a < 0)
			output = (Math.abs(a) * c) + d + (b * e);
		else if(a == 0)
			output = d + (b * e);
		else
			output = (b - a) * e;
		// 출력
		System.out.print(output);
	}
}