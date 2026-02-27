import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr31009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int jinju = 0;
		int output = 0;
		int[] money = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String place = st.nextToken();
			int pay = Integer.parseInt(st.nextToken());
			money[i] = pay;
			// 진주 교통편 찾기
			if(place.equals("jinju"))
				jinju = pay;
		}
		// 진주보다 비싼 교통편 개수 세기
		for(int i=0; i<n; i++) {
			if(jinju < money[i])
				output++;
		}
		// 출력
		System.out.println(jinju);
		System.out.print(output);
	}
}