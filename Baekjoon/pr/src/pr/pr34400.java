import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34400 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int time = Integer.parseInt(br.readLine());
			// 출력
			if(time%25 < 17)
				System.out.println("ONLINE");
			else
				System.out.println("OFFLINE");
		}
	}
}