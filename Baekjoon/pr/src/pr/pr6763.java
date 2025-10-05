import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6763 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int limit = Integer.parseInt(br.readLine());
		int speed = Integer.parseInt(br.readLine());
		// 출력
		if(limit >= speed)
			System.out.print("Congratulations, you are within the speed limit!");
		else {
			if(1 <= speed-limit && speed-limit <= 20)
				System.out.print("You are speeding and your fine is $100.");
			else if(21 <= speed-limit && speed-limit <= 30)
				System.out.print("You are speeding and your fine is $270.");
			else if(31 <= speed-limit)
				System.out.print("You are speeding and your fine is $500.");
		}
	}
}