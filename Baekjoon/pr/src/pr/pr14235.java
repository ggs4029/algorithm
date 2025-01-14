// 백준 14235번
// 산타가 착한 아이들에게 선물을 나눠준다.
// 산타의 썰매는 그렇게 크지 않기 때문에, 세계 곳곳에 거점들을 세워 그 곳을 방문하며 선물을 충전해 나갈 것이다.
// 또한, 착한 아이들을 만날 때마다 자신이 들고있는 가장 가치가 큰 선물 하나를 선물해 줄 것이다.
// 차례대로 방문한 아이들과 거점지의 정보들이 주어졌을 때, 아이들이 준 선물들의 가치들을 출력하는 문제.
// 아이들에게 줄 선물이 없다면 -1 출력.
// 방법---------------------
// 첫째 줄에 아이들과 거점지를 방문한 횟수 n이 주어짐.
// 그 다음 줄부터 a가 들어오고, 그 다음 a개의 숫자가 들어온다.
// 이는 거점지에서 a개의 선물을 충전하는 것이고, 그 숫자들이 선물의 가치이다.
// a가 0이면 거점지가 아니라 아이들을 만난 것.
// 내림차순 우선순위 큐 만들어서 사용.
// a가 0일 때랑 아닐 때 구분해서 연산하고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr14235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y-x);
		for(int i=0; i<n; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==0) {													// 애들 만난 경우
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.poll()).append("\n");
			}
			else {														// 거점지에서 선물 충전
				for(int j=0; j<a; j++)
					q.offer(Integer.parseInt(st.nextToken()));
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}