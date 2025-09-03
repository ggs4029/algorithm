// 백준 18311번
// n개의 이어진 일직선상의 코스를 모두 지나
// 끝까지 도달한 뒤에 다시 출발지점으로 돌아와야 함.
// 현재 이동거리가 k일 때, 현재 지나고 있는 코스의 번호를 출력하는 문제.
// 방법---------------------
// 첫 줄에 정수 n과 k가 주어짐.
// 다음 줄에 1번 부터 n번까지 각 코스의 길이가 한 줄에 다 주어짐.
// 순회하면서 코스 길이를 빼줬는데도 0보다 크면
// 반환점을 돈 것이므로 다시 계산해서 코스 번호를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr18311 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		int[] lane = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			lane[i] = Integer.parseInt(st.nextToken());
		// 코스 번호 구하고 출력
		boolean tmp = false;
		for(int i=0; i<n; i++) {
			k -= lane[i];
			if(k < 0) {
				System.out.print(i + 1);
				tmp = true;
				break;
			}
		}
		if(tmp == false) {								// 반환점 돌았으면
			for(int i=n-1; i>=0; i--) {
				k -= lane[i];
				if(k < 0) {
					System.out.print(i + 1);
					break;
				}
			}
		}
	}
}