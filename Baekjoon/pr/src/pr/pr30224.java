import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		boolean tmp1 = String.valueOf(n).contains("7");
		boolean tmp2;
		if(n%7 == 0)
			tmp2 = true;
		else
			tmp2 = false;
		// 출력
		if(tmp1 && tmp2)
			System.out.print(3);
		else if(!tmp1 && tmp2)
			System.out.print(1);
		else if(tmp1 && !tmp2)
			System.out.print(2);
		else
			System.out.print(0);
	}
}