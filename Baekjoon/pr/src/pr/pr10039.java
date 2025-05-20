import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10039 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<5; i++) {
			// 입력
			int input = Integer.parseInt(br.readLine());
			// 보충해야되는지
			if(input < 40)
				input = 40;
			sum += input;
		}
		// 평균 출력
		System.out.print(sum / 5);
	}
}