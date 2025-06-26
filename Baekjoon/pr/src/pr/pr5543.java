import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int burger = 2001;
		int drink = 2001;
		// 버거랑 음료 가격
		for(int i=0; i<3; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp < burger)
				burger = tmp;
		}
		for(int i=0; i<2; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp < drink) {
				drink = tmp;
			}
		}
		// 출력
		System.out.print(burger + drink - 50);
	}
}