import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int s = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		// 출력
		if(s > f)
			System.out.print("flight");
		else
			System.out.print("high speed rail");
	}
}