import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1297 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double d = Double.parseDouble(st.nextToken());
		double h = Double.parseDouble(st.nextToken());
		double w = Double.parseDouble(st.nextToken());
		// 높이랑 너비 구하기
		double p = Math.pow(d, 2) / (Math.pow(h, 2) + Math.pow(w, 2));
		int output1 = (int) (Math.sqrt(p) * h);
		int output2 = (int) (Math.sqrt(p) * w);
		// 출력
		System.out.print(output1 + " " + output2);
	}
}