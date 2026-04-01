import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 부모님께 드릴 금액 + 내가 가질 금액 구하기
		double per = 0;
		if(n >= 1000000)
			per = 0.20;
		else if(n >= 500000)
			per = 0.15;
		else if(n >= 100000)
			per = 0.10;
		else
			per = 0.05;
		int parents = (int) (n * per);
		int me = n - parents;
		// 출력
		System.out.print(parents + " " + me);
	}
}