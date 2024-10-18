// 백준 1966번
// 중요도가 있는 큐 구현하기
// 방법---------------------
// 첫 줄에 테스트 케이스의 수 t를 입력 받고
// 테스트 케이스마다 첫 줄에는 문서의 개수 n,
// 몇번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇 번째에 놓여 있는지를 나타내는 정수 m을 입력 받고
// 다음 줄에는 n개의 문서의 중요도를 입력 받음.
// 연결리스트를 큐처럼 사용.
// 헤드의 문서의 중요도가 가장 큰지 for문을 돌며 검사하고 내가 찾는 문서가 몇번째에 나오는지 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class pr1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int x=0; x<t; x++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			String[] input2 = br.readLine().split(" ");
			LinkedList<int[]> l = new LinkedList<>();
			for(int y=0; y<n; y++)
				l.add(new int[] {y, Integer.parseInt(input2[y])});
			// 중요도에 따른 출력 순서 구하기
			int sum = 0;
			while(!l.isEmpty()) {
				int[] head = l.poll();								// 맨앞의 값
				boolean tmp = true;
				// 헤드값 중요도 비교
				for(int i=0; i<l.size(); i++) {
					if(head[1]<l.get(i)[1]) {						// 중요도 낮으면
						l.offer(head);								// 뽑아내 뒤로
						for(int j=0; j<i; j++)						// 전의 원소들도
							l.offer(l.poll());						// 뽑아내 뒤로
						tmp = false;
						break;
					}
				}
				// 헤드가 가장 중요도가 큰게 아니면
				if(tmp==false)
					continue;										// 아래 스킵하고 다음꺼
				// 헤드가 가장 중요도가 크면
				sum++;												// 출력
				if(head[0]==m)										// 찾고있는 문서면
					break;
			}
			// 출력
			System.out.println(sum);
		}
	}
}