// 백준 20246번
// 10x10 그리드에서 팩맨이 모든 점을 먹도록 경로 구성하는 문제.
// 방법---------------------
// 첫 줄에 시작 점 (x, y)를 입력 받음.
// 경로 구성 -> x, y에서 0, 0으로 돌려보내고 거기부터 다시 시작하도록 구성.
// 경로 모두 append해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		StringBuilder sb = new StringBuilder();
		// 경로 구성1 - 0, 0으로 보내기
		while(x>=0) {
			sb.append(x+" "+y).append("\n");
			if(y>0)
				y--;
			else
				x--;
		}
		x++;
		// 경로 구성2 - 모든 점 먹도록 쭉 돌기
		while(x<=9) {
			if(x%2==0) {
				if(y<9)
					y++;
				else
					x++;
			}
			else {
				if(y>0)
					y--;
				else
					x++;
			}
			if(x!=10)
				sb.append(x+" "+y).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}