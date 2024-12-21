// 백준 2303번
// 각 사람에게 1~10 사이의 카드가 다섯장 주어지고,
// 그 중 세 장의 카드를 골라 합을 구한 후 일의 자리 수가 가장 큰 사람이 게임을 이기게 됨.
// 방법---------------------
// 첫 줄에 사람 수 n이 입력으로 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 뽑은 카드 다섯장이 주어진다.
// for문 돌면서 세 카드 선택해 일의 자리 구하고 max비교.
// 제일 큰 사람 우승자로 해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2303 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int last = -1557;
		int index = 1557;
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int[] card = new int[5];
			for(int j=0; j<5; j++)
				card[j] = Integer.parseInt(input[j]);
			// 제일 큰 일의 자리 구하기
			int tmp = 0;
			for(int x=0; x<5; x++) {
				for(int y=x+1; y<5; y++) {
					for(int z=y+1; z<5; z++) {
						tmp = Math.max(tmp, (card[x]+card[y]+card[z]) % 10);
					}
				}
			}
			if(tmp>=last) {
				last = tmp;
				index = i + 1;
			}
		}
		// 출력
		System.out.print(index);
	}
}