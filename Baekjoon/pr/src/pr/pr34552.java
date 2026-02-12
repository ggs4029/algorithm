import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] scholarship = new int[11];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<=10; i++)
			scholarship[i] = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		// 장학금 총액 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());		// 분위
			double l = Double.parseDouble(st.nextToken());	// 학기 평점
			int s = Integer.parseInt(st.nextToken());		// 취득 학점
			if(s>=17 && l>=2.0)								// 17학점 이상 평점2.0 이상이면
				output += scholarship[b];
		}
		//출력
		System.out.print(output);
	}
}