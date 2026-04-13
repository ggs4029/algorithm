import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24087 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int s = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		// 필요한 돈 계산
		int money = 250;						// 기본 금액
		if(s>a && (s-a)%b==0)
			money += ((s - a) / b) * 100;
		else if(s>a && (s-a)%b!=0)
			money += (((s - a) / b) + 1) * 100;
		// 출력
		System.out.print(money);
	}
}