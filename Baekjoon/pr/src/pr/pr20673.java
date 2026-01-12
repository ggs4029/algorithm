import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20673 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int p = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		// 출력
		if(p<=50 && q<=10)
			System.out.print("White");
		else if(q > 30)
			System.out.print("Red");
		else
			System.out.print("Yellow");
	}
}