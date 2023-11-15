// 백준 2161번
// N장의 카드가 순서대로 놓여져 있을때
// 문제의 방법에 따라 카드를 버리고 섞고를 반복한 뒤
// 카드를 버리는 순서와 마지막에 남는 카드를 출력하는 문제
// 방법--------------------
// 카드의 개수 n을 입력 받고
// 그 크기만큼 ArrayList를 만들고 차례로 정수를 집어넣는다.
// 문제에서 제시한 방법대로 for문을 돌며
// 맨 위 카드는 버리고 출력한 뒤 그 다음 카드는 맨 아래로 섞는다.
// for문을 다돌았으면 ArrayList에 맨 마지막으로 남은 원소까지 출력해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr2161 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n입력
		int n = Integer.parseInt(br.readLine());
		// 배열 생성
		ArrayList<Integer> card = new ArrayList<Integer>(n);
		for(int x=0; x<n; x++)
			card.add(x+1);
		// 제시한 방법에 따라 카드 버리기와 섞기 수행
		for(int x=0; x<n-1; x++) { // n-1장 카드를 버리게 될 것
			// 맨 앞의 카드를 버린다
			int rm = card.remove(0);
			System.out.print(rm+ " ");
			// 그 다음 카드를 맨 뒤로 넣는다
			card.add(card.get(0));
			card.remove(0); // 맨 뒤로 넣은 뒤 삭제
		}
		// 맨 마지막으로 남은 원소를 출력해준다
		System.out.print(card.get(0));
	}
}