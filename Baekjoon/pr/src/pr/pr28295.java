import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28295 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		for(int i=0; i<10; i++)
			sum += Integer.parseInt(br.readLine());
		// 출력
		if(sum%4 == 0)
			System.out.print("N");
		else if(sum%4 == 1)
			System.out.print("E");
		else if(sum%4 == 2)
			System.out.print("S");
		else if(sum%4 == 3)
			System.out.print("W");
	}
}