// 백준 2444번
// 별찍기 - 7
// 방법---------------
// N을 입력받고
// 각 줄의 별은 2N-1개
// 각 줄의 공백은 N-1개

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N 입력받기
		int N = Integer.parseInt(br.readLine());
		// 위쪽 별 찍기
		for(int x=1; x<=N; x++) {
			for(int y=1; y<=N-x; y++) {
				System.out.print(" ");
			}
			for(int z=1; z<=2*x-1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 아래쪽 별 찍기
		for(int x=N-1; x>=1; x--) { // x=N-1로 중복되는 줄 제거
			for(int y=N-x; y>=1; y--) {
				System.out.print(" ");
			}
			for(int z=2*x-1; z>=1; z--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
