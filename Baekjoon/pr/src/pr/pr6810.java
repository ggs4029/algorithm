import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int z = Integer.parseInt(br.readLine());
		// 출력
		System.out.print("The 1-3-sum is ");
        System.out.print(91 + x + y * 3 + z);
	}
}