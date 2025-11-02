import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class pr16099 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		for(int i=0; i<a; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger lt = new BigInteger(st.nextToken());
			BigInteger wt = new BigInteger(st.nextToken());
			BigInteger le = new BigInteger(st.nextToken());
			BigInteger we = new BigInteger(st.nextToken());
			// 출력
			int tmp = lt.multiply(wt).compareTo(le.multiply(we));
			if(tmp == 1)
				System.out.println("TelecomParisTech");
			else if(tmp == -1)
				System.out.println("Eurecom");
			else
				System.out.println("Tie");
		}
	}
}