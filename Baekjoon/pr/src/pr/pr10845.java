// 백준 10845번
// 정수를 저장하는 큐를 구현하고
// 입력으로 주어지는 명령을 처리하는 프로그램을 만드는 문제
// 방법---------------------
// 첫 줄에 명령의 개수 n을 입력 받음.
// 다음 줄부터 명령들을 입력 받음.
// 명령에 맞는 행동을 하고 알맞게 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = 0;
		for(int i=0; i<n; i++) {
			// 명령 입력
			String[] input = br.readLine().split(" ");
			// 명령 수행과 출력
			if(input[0].equals("push")) {
				q.add(Integer.parseInt(input[1]));
				last = Integer.parseInt(input[1]);
			}
			else if(input[0].equals("pop")) {
				if(q.size()!=0)
					System.out.println(q.poll());
				else
					System.out.println(-1);
			}
			else if(input[0].equals("size")) {
				System.out.println(q.size());
			}
			else if(input[0].equals("empty")) {
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(input[0].equals("front")) {
				if(q.size()!=0)
					System.out.println(q.peek());
				else
					System.out.println(-1);
			}
			else {					// back 명령
				if(q.size()!=0)
					System.out.println(last);
				else
					System.out.println(-1);
			}
		}
	}
}