import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34544 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int floor = 1;												// 지금 내 층
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 상대적인 층수 구하기
			int tmp = b - a;										// 이동하는 층 수
			if(a<0 && b>0)											// 지하에서 지상으로
				tmp--;												// 0층은 없으니까 -1
			else if(a>0 && b<0)										// 지상에서 지하로
				tmp++;												// 0층 없음 +1
			int tmp2 = floor + tmp;									// 다음 내 위치
			if(floor>0 && tmp2<=0)
				tmp2--;
			else if(floor<0 && tmp2>=0)
				tmp2++;
			floor = tmp2;
		}
		// 출력
		System.out.print(floor);
	}
}