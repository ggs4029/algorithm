// 백준 32219번
// 말의 처음 위치가 주어졌을 때 진서와 도훈이 중 누가 이기는지 알아내고, 진서가 이긴다면 이기는 방법도 구해보자.
// 보드게임 룰은 문제 참조.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 이어서 t개 줄에 말의 시작 위치가 주어짐.
// 첫 이동을 정사각형으로 줄이기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t;  i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			if(r!=c) {
				sb.append("jinseo").append("\n");
				int tmp = Math.min(r, c);
				sb.append(tmp + " " + tmp).append("\n");
			}
			else
				sb.append("dohoon").append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}