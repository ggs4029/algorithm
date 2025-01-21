// 백준 16206번
// 재현이는 친구 N명에게 롤케이크를 1개씩 선물로 받았다.
// 재현이는 길이가 10인 롤케이크만 먹는다. 따라서, 롤케이크를 잘라서 길이가 10인 롤케이크를 최대한 많이 만들려고 한다.
// 롤케이크를 최대 M번 자를 수 있을 때, 만들 수 있는 길이가 10인 롤케이크 개수의 최댓값을 구하는 문제.
// 롤케이크를 자르는 방법(과정)은 문제를 참조.
// 방법---------------------
// 첫 줄에 n, m이 주어짐.
// 둘째 줄에 롤케이크의 길이들이 n개 주어진다.
// 우선순위큐 만져서 사용.
// 길이 10으로 잘라가며 10으로 안 나누어떨어지면 다시 큐에 넣는식으로 사용.
// m값에 주의하며 롤케이크 개수 최댓값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr16206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> {
			if (x%10 == y%10)								// 일의 자리 같으면
				return x/10 - y/10;							// 몫으로 정렬
			return x%10 - y%10;								// 기본적으로 일의 자리로 정렬
		});
		// 길이 10인 롤케이크 최댓값 구하기
		st = new StringTokenizer(br.readLine());
		int output = 0;
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp > 10)									// 10보다 길면
				q.add(tmp);									// 큐에 넣기
			else if(tmp == 10)								// 딱 10이면 그냥 답 +1
				output++;
		}
		while(m>0 && !q.isEmpty()) {
			int tmp = q.poll();
			tmp -= 10;										// 10으로 자르고
			if(tmp == 10)
				output++;
			else if(tmp > 10)								// 길이 남으면 큐에 다시 넣기
				q.add(tmp);
			m--;
			output++;
		}
		// 출력
		System.out.print(output);
	}
}