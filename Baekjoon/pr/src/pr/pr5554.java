import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5554 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = Integer.parseInt(br.readLine());
		for(int i=0; i<3; i++)
			sum += Integer.parseInt(br.readLine());
		// 출력
		System.out.println(sum / 60);
		System.out.print(sum % 60);
	}
}