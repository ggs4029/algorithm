import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		String[] kda = input.split("/");
		int k = Integer.parseInt(kda[0]);
		int d = Integer.parseInt(kda[1]);
		int a = Integer.parseInt(kda[2]);
		// 출력
		if(k+a<d || d==0)
			System.out.print("hasu");
		else
			System.out.print("gosu");
	}
}