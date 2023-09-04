// 백준 3009번
// 세 점이 주어지면 직사각형을 만들기 위해 필요한
// 네번째 점을 찾는 문제
// 방법--------------------------------
// 세 점의 좌표를 한 줄씩 입력 받고
// 나머지 한 점의 x좌표와 y좌표를 계산해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] p1 = br.readLine().split(" ");
		int x1 = Integer.parseInt(p1[0]);
		int y1 = Integer.parseInt(p1[1]);
		String[] p2 = br.readLine().split(" ");
		int x2 = Integer.parseInt(p2[0]);
		int y2 = Integer.parseInt(p2[1]);
		String[] p3 = br.readLine().split(" ");
		int x3 = Integer.parseInt(p3[0]);
		int y3 = Integer.parseInt(p3[1]);
		// x좌표 찾기
		if(x1==x2) {
			System.out.print(x3+" ");
		}
		else if(x1==x3) {
			System.out.print(x2+" ");
		}
		else {
			System.out.print(x1+" ");
		}
		// y좌표 찾기
		if(y1==y2) {
			System.out.print(y3+" ");
		}
		else if(y1==y3) {
			System.out.print(y2+" ");
		}
		else {
			System.out.print(y1+" ");
		}
	}
}