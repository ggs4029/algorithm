import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		// 주차 요금 계산
		int output = a;
		if(t > 30) {
			int over = t - 30;						// 30분 초과한 시간
			int count = (over + b - 1) / b;			// 초과요금 몇 번 내야 하는지 내야 할 개수
			output += c * count;
		}
		// 출력
		System.out.print(output);
	}
}