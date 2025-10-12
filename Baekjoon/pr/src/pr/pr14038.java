import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14038 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int output = 0;
		for(int i=0; i<6; i++) {
			String input = br.readLine();
			if(input.equals("W"))
				output++;
		}
		// 출력
		if(output > 4)
			System.out.print(1);
		else if(output > 2)
			System.out.print(2);
		else if(output > 0)
			System.out.print(3);
		else
			System.out.print(-1);
	}
}