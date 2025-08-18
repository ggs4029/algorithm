import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17362 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		//출력
		if(n%8 == 0)
			System.out.print(2);
		else if(n%4 == 3)
			System.out.print(3);
		else if(n%8 == 6)
			System.out.print(4);
		else
			System.out.print(n%8);
	}
}