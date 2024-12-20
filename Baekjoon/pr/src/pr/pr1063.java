// 백준 1063번
// 8*8크기 체스판에 킹이 하나 있고, 말의 위치가 A1 이런식으로 주어짐.
// 체스판에는 돌이 하나 있는데, 돌과 같은 곳으로 이동할 때는, 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동.
// 입력으로 주어진 대로 움직여서 킹이나 돌이 체스판 밖으로 나갈 경우에는 그 이동은 건너 뛰고 다음 이동을 한다.
// 킹과 돌의 마지막 위치를 구하는 프로그램을 작성.
// 방법---------------------
// 첫째 줄에 킹 위치랑 돌 위치, 움직이는 횟수 n 세개가 주어진다.
// 둘째 줄부터 n개의 줄에는 킹이 어떻게 움직여야 하는지 주어짐.
// 문제에서 주어진대로 구현해서 풀이.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1063 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		char[] king = input[0].toCharArray();
		char[] rock = input[1].toCharArray();
		int n = Integer.parseInt(input[2]);
		for(int i=0; i<n; i++) {
			String input2 = br.readLine();
			// 말 움직이기
			char[] tmp = move(input2, king);
			if(check(tmp)) {											// 킹 움직이고 범위 안이면
				if(tmp[0]==rock[0] && tmp[1]==rock[1]) { 				// 킹 돌이랑 겹치면
					char[] tmp_rock = move(input2, rock);
					if(check(tmp_rock)) {								// 돌도 움직이고 범위 안이면
						king = tmp;
						rock = tmp_rock;
					}
					else												// 돌 범위 밖이면 다음 입력
						continue;
				}
				else													// 돌이랑 안겹치면
					king = tmp;											// 킹만 이동
			}
			else														// 킹 범위 밖이면 다음 입력
				continue;
		}
		// 출력
		System.out.println(king[0] + "" + king[1]);
		System.out.print(rock[0] + "" + rock[1]);
	}

	// 이동 메소드
	public static char[] move(String tmp, char[] target) {
		char[] result = target.clone();
		if(tmp.equals("L"))
			result[0]--;
		else if(tmp.equals("R"))
			result[0]++;
		else if(tmp.equals("B"))
			result[1]--;
		else if(tmp.equals("T"))
			result[1]++;
		else if(tmp.equals("RT")) {
			result[0]++;
			result[1]++;
		}
		else if(tmp.equals("LT")) {
			result[0]--;
			result[1]++;
		}
		else if(tmp.equals("RB")) {
			result[0]++;
			result[1]--;
		}
		else if(tmp.equals("LB")) {
			result[0]--;
			result[1]--;
		}
		return result;
	}

	// 체스판 범위 안인지 확인하는 메소드
	public static boolean check(char[] c) {
		return c[0]>='A' && c[0]<='H' && c[1]>='1' && c[1]<='8';
	}
}