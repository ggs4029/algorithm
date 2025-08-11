import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		for(int i=0; i<4; i++)
			sum += Integer.parseInt(br.readLine());
		// 출력
		if(1800-sum >= 300)
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}