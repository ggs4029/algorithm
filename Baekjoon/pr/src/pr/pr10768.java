import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10768 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int m = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		// 출력
		if(m < 2)
			System.out.print("Before");
		else if(m == 2) {
			if(d < 18)
				System.out.print("Before");
			else if(d == 18)
				System.out.print("Special");
			else
				System.out.print("After");
		}
		else
			System.out.print("After");
	}
}