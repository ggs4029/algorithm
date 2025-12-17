import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30402 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		for(int i=0; i<15; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<15; j++) {
				// 입력
				String input = st.nextToken();
				// 출력
				if(input.equals("w")) {
					System.out.print("chunbae");
					return;
				}
				else if(input.equals("b")) {
					System.out.print("nabi");
					return;
				}
				else if(input.equals("g")) {
					System.out.print("yeongcheol");
					return;
				}
			}
		}
	}
}