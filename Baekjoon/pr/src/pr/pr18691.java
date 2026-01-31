import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr18691 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 걸어야하는 거리 구하기
			int sum = 0;
			if(g == 1)
				sum = e - c;
			else if(g == 2)
				sum = (e - c) * 3;
			else if(g == 3)
				sum = (e - c) * 5;
			if(c >= e)
				sum = 0;
			// 출력
			System.out.println(sum);
		}
	}
}