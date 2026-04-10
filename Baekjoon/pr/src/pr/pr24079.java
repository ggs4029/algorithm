import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int z = Integer.parseInt(br.readLine());
		// 출력
		if((x+y)*60 <= z*60+30)
			System.out.print("1");
		else
			System.out.print("0");
	}
}