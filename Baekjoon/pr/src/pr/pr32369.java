import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr32369 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// n일 후 길이 구하기
		int good = 1;						// 칭찬양파
		int blame = 1;						// 비난양파
		while(n-- > 0) {
			good += a;
			blame += b;
			if(good < blame) {				// 비난양파가 더 크면
				int tmp = good;
				good = blame;
				blame = tmp;
			}
			else if(good == blame)
				blame--;
		}
		// 출력
		System.out.print(good + " " + blame);
	}
}