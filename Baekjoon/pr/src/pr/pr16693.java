import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16693 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a1 = Double.parseDouble(st.nextToken());
		double p1 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double r1 = Double.parseDouble(st.nextToken());
		double p2 = Double.parseDouble(st.nextToken());
		// 출력
		if(a1/p1 > (r1 * r1 * Math.PI)/p2)
			System.out.print("Slice of pizza");
		else
			System.out.print("Whole pizza");
	}
}