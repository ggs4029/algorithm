import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr26209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<8; i++) {
			if(st.nextToken().equals("9")) {
				System.out.print("F");
				return;
			}
		}
		// 출력
		System.out.print("S");
	}
}