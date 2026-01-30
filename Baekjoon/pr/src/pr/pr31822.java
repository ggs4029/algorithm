import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String code = br.readLine().substring(0, 5);
		int num = Integer.parseInt(br.readLine());
		// 재수강할 과목 개수 구하기
		int sum = 0;
		for(int i=0; i<num; i++) {
			// 입력2
			String code2 = br.readLine().substring(0, 5);
			// 코드 같으면 재수강
			if(code2.equals(code))
				sum++;
		}
		// 출력
		System.out.print(sum);
	}
}