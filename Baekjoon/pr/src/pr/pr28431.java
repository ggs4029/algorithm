import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] num = new int[5];
		for(int i=0; i<5; i++)
			num[i] = Integer.parseInt(br.readLine());
		int i = 0;
		for(i=0; i<5; i++) {
			int sum = 0;
			for(int j=0; j<5; j++) {
				if(num[i] == num[j])
					sum++;
			}
			if(sum%2 == 1)
				break;
		}
		// 출력
		System.out.print(num[i]);
	}
}