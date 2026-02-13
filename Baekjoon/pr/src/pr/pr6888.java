import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		// 출력
		for(int i=a; i<=b; i+=60)
			System.out.println("All positions change in year " + i);
	}
}