import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr25704 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		// 물건 가격 구하기
		int output = 0;
		if(n < 5)
			output = p;
		else if(n>=5 && n<10)
			output = p - 500;
		else if(n>=10 && n<15)
			output = (int) Math.min((p * 0.9), (p - 500));
		else if(n>=15 && n<20) {
			output = (int) Math.min(((p * 0.9)), (p - 2000));
			output = Math.min(output, p - 500);
		}
		else if(n >= 20) {
			output = (int) Math.min((p - 2000), (p * 0.75));
			output = Math.min(output, p - 500);
		}
		if(output < 0)
			output = 0;
		// 출력
		System.out.print(output);
	}
}