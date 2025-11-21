import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr29736 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		// 자격을 갖춘 친구 수 세기
		int sum = 0;
		for(int i=k-x; i<k+x+1; i++) {
			if(i<a || i>b)
				continue;
			sum++;
		}
		// 출력
		if(sum == 0)
			System.out.print("IMPOSSIBLE");
		else
			System.out.print(sum);
	}
}