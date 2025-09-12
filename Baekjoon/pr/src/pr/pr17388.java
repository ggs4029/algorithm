import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17388 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// 최솟값 구하고 무언의 압박 보내기
		int sum = s + k + h;
		int min = Math.min(s, k);
		min = Math.min(min, h);
		if(sum >= 100)
			System.out.print("OK");
		else {
			if(min == s)
				System.out.print("Soongsil");
			else if(min == k)
				System.out.print("Korea");
			else
				System.out.print("Hanyang");
		}
	}
}