// 백준 11968번
// 2n개의 카드를 가지고 n라운드 게임을 할거임.
// 상대가 어떤 카드를 낼지 알고있을 때, 이 정보를 바탕으로 내가 획득할 수 있는 최대 점수를 구하는 문제.
// 방법---------------------
// 첫 줄에 정수 n을 입력 받음.
// 이후 n줄에 걸쳐 상대가 라운드별로 어떤 카드를 내는지 입력 받음.
// 내 카드랑 상대카드 리스트로 분리하고 (정렬된 상태)
// 첫 값부터 시작해서 비교해가며 최대 점수 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class pr11968 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		boolean[] card = new boolean[2*n + 1];
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			card[tmp] = true;
		}
		// 최대 점수 구하기
		int output = 0;
		List<Integer> elsie = new ArrayList<>();				// 상대방
		List<Integer> bessie = new ArrayList<>();				// 나
		for(int i=1; i<2*n+1; i++) {
			if(card[i] == true)
				elsie.add(i);
			else
				bessie.add(i);
		}
		for(int e=0, b=0; e<n && b<n; b++) {
			if(bessie.get(b) > elsie.get(e)) {					// 내가 이기면
				e++;
				output++;
			}
		}
		// 출력
		System.out.print(output);
	}
}