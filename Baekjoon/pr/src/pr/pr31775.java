import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int l = 0;
		int k = 0;
		int p = 0;
		for(int i=0; i<3; i++) {
			String input = br.readLine();
			// l, k, p로 시작하는지
			if(input.charAt(0) == 'l')
				l++;
			else if(input.charAt(0) == 'k')
				k++;
			else if(input.charAt(0) == 'p')
				p++;
		}
		// 출력
		if(l==1 && k==1 && p==1)
			System.out.print("GLOBAL");
		else
			System.out.print("PONIX");
	}
}