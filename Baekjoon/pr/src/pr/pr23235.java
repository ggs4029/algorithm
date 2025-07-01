import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = 0;
		while(true){
			String input = br.readLine();
			if(input.charAt(0)=='0')
				break;
			n++;
		}
		for(int i=1; i<=n; i++)
			sb.append(String.format("Case %d: Sorting... done!\n", i));
		// 출력
		System.out.print(sb.toString().trim());
	}
}