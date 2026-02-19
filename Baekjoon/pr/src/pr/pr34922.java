import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(br.readLine());
		// 딴 짓 할 수 있는 범위 구하기
		double classroom = w * h;
		double teacher = Math.pow(r, 2) * 3.14 / 4;
		// 출력
		System.out.print(String.format("%.3f", classroom - teacher));
	}
}