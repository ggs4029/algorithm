import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13580 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 출력
		if(a==b || b==c || a==c)							// 시간 여행 두번만 가면 되는 경우
			System.out.print("S");
		else if(a+b==c || a+c==b || b+c==a)					// 세번 다 가야되는 경우
			System.out.print("S");
		else												// 나머진 불가능
			System.out.print("N");
	}
}