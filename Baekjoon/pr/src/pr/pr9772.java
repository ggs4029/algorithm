import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9772 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			// 입력
			StringTokenizer st = new StringTokenizer(input);
			if(!st.hasMoreTokens())
				break;
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			// 사분면 판별하고 출력
			if(a>0 && b>0)
				System.out.println("Q1");
			else if(a<0 && b>0)
				System.out.println("Q2");
			else if(a<0 && b<0)
				System.out.println("Q3");
			else if(a>0 && b<0)
				System.out.println("Q4");
			else
				System.out.println("AXIS");
		}
	}
}