import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 출력
		if(l==0 && r==0)
			System.out.print("Not a moose");
		else if(l == r)
			System.out.print("Even " + (l + r));
		else if(l != r) {
			if(l > r)
				System.out.print("Odd " + l * 2);
			else
				System.out.print("Odd " + r *2);
		}
	}
}