import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int output = 0;
		for(int i=0; i<5; i++) {
			if(t == Integer.parseInt(st.nextToken()))
				output++;
		}
		// 출력
		System.out.print(output);
	}
}