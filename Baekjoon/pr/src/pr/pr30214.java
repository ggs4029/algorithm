import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double s1 = Double.parseDouble(st.nextToken());
		double s2 = Double.parseDouble(st.nextToken());
		// 출력
		if(s1 >= s2/2)
			System.out.print("E");
		else
			System.out.print("H");
	}
}