import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr31994 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String output = "";
		int max = 0;
		for(int i=0; i<7; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			String seminar = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			// 신청자 수 비교
			if(max < num) {
				max = num;
				output = seminar;
			}
		}
		// 출력
		System.out.print(output);
	}
}