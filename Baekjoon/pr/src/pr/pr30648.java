// 백준 30648번
// 트릭 플라워를 심었을 때 적어도 몇 초후에 한 좌표에 두 송이의 꽃이 존재하는지 구하는 문제.
// 부등식 (xt + 1) + (yt + 1) < R 이 참이라면 xt + 1과 yt + 1은 각각 xt + 1, yt + 1 이다.
// 그렇지 않다면 xt + 1과 yt + 1은 각각 xt ÷ 2, yt ÷ 2 이다.
// 단 계산 과정에서 소수점은 모두 버리며, 여러 송이의 꽃이 한 좌표에 필 수도 있다.
// 방법---------------------
// 첫 줄에 꽃을 심는 첫 좌표 a, b가 주어짐.
// 둘째 줄에 r이 주어짐.
// 무한루프를 돌며 한 좌표에 꽃이 두번 심어질때까지 꽃을 계속 심고 최소 초를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30648 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int r = Integer.parseInt(br.readLine());
		int[][] flower = new int[r][r];
		flower[a][b]++;
		// 초 구하기
		int output = 0;
		while(true) {
			output++;
			if(a+1+b+1<r) {
				a += 1; b += 1;
			}
			else {
				a /= 2; b /= 2;
			}
			flower[a][b]++;
			if(flower[a][b]>=2)
				break;
		}
		// 출력
		System.out.print(output);
	}
}