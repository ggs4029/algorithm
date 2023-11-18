// 백준 2798번
// 블랙잭
// N장의 카드에 써져 있는 숫자가 주어졌을 때
// M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구하기
// 방법----------------
// n과 m을 한줄에 입력 받고
// 다음줄에 n개의 숫자들을 한줄에 입력 받는다.
// 3중 for문을 사용해 1,2,3번째 카드를 뽑고
// 세 숫자의 합을 m과 answer과 비교해가며
// 최대한 가까운 카드 세장의 합을 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		String[] input2 = br.readLine().split(" ");
		int[] cards = new int[n];
		for(int x=0; x<n; x++) {
			cards[x] = Integer.parseInt(input2[x]);
		}
		// 카드 찾기
		int answer = 0;
		for(int x=0; x<cards.length-2; x++) { // 첫번째 카드
			for(int y=x+1; y<cards.length-1; y++) { // 두번째 카드
				for(int z=y+1; z<cards.length; z++) { // 세번째 카드
					int sum = cards[x] + cards[y] + cards[z];
					if(sum == m) { // 합이 m이 되면
						answer = sum; // 답을 갱신
					}
					if(answer < sum && sum < m) { // 답이 합보다 작고 합이 m보다 작으면
						answer = sum; // 답을 갱신
					}
				}
			}
		}
		// 출력
		System.out.print(answer);
	}
}