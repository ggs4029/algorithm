//백준 19638번
// 마법의 뿅망치로 매번 가장 키가 큰 거인 가운데 하나를 때릴 때
// 망치 횟수 제한을 모두 소모하고나서 거인의 나라의 모든 거인이
// 센티보다 키가 작도록 할 수 있는지 구하는 문제.
// 뿅망치로 거인 치면 뿅망치에 맞은 사람의 키 / 2
//방법---------------------
// 첫 줄에 거인 나라 인구수 n과 센티 키 h, 망치 사용 가능 횟수 t를 입력 받음.
// 다음 줄부터 n줄에 걸쳐 거인들의 키를 입력 받음.
// 우선순위 큐로 제일 큰애부터 망치로 내려쳐가면서
// 망치 횟수 소모 다했을 때 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr19638 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int centi = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		// 최대 힙을 구현하기 위해 Collections.reverseOrder() 사용
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++)
			q.add(Integer.parseInt(br.readLine()));
		// 망치로 거인 치기
		int output = 0;
		while(!q.isEmpty() && t>0) {
			int tmp = q.peek();
			if(tmp < centi)							// 제일 큰 애가 센티보다 작으면
				break;								// 탈출
			q.poll();
			if(tmp == 1) {
				q.add(tmp);
				break;
			}
			q.add(tmp / 2);							// 반으로 줄이고 다시 넣기
			t--;
			output++;
		}
		// 출력
		int output2 = q.peek();
		if(output2 < centi) {
			System.out.println("YES");
			System.out.print(output);
		}
		else {
			System.out.println("NO");
			System.out.print(output2);
		}
	}
}