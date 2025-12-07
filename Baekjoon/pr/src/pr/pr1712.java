import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());		// 고정 비용
		int b = Integer.parseInt(st.nextToken());		// 가변 비용
		int c = Integer.parseInt(st.nextToken());		// 제품 가격
		// 손익분기점 구하고 출력
		if(c <= b) {									// c가 더 작으면 아무리 팔아도 차이가 안줄어듬
			System.out.print(-1);
			return;
		}
		else
			System.out.print((a / (c - b)) + 1);
	}
}