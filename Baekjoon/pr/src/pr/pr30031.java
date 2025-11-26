import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30031 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		while(n--> 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			if(money == 136)
				sum += 1000;
			else if(money == 142)
				sum += 5000;
			else if(money == 148)
				sum += 10000;
			else if(money == 154)
				sum += 50000;
		}
		// 출력
		System.out.print(sum);
	}
}