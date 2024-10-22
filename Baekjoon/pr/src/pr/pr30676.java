// 백준 30676번
// 파장 값에 따른 별의 색 출력하기
// 방법---------------------
// 첫 줄에 파장 lambda를 입력 받는다.
// if문을 사용해 별의 색을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int lambda = Integer.parseInt(br.readLine());
		// 색 판별 and 출력
		if(lambda>=380 && lambda<425)
			System.out.print("Violet");
		else if(lambda>=425 && lambda<450)
			System.out.print("Indigo");
		else if(lambda>=450 && lambda<495)
			System.out.print("Blue");
		else if(lambda>=495 && lambda<570)
			System.out.print("Green");
		else if(lambda>=570 && lambda<590)
			System.out.print("Yellow");
		else if(lambda>=590 && lambda<620)
			System.out.print("Orange");
		else
			System.out.print("Red");
	}
}