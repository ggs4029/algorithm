// 백준 10828번
// 정수를 저장하는 스택을 구현하고
// 입력으로 주어지는 명령을 처리하는 프로그램을 만드는 문제
// 방법---------------------
// 첫 줄에 주어지는 명령의 수 n을 입력 받음.
// 다음줄부터 명령이 주어짐.
// 입력에 따라 문제에서 주어진 명령을 수행하고 알맞은 답을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++) {
			// 명령 입력
			String[] input = br.readLine().split(" ");
			// 명령 수행과 출력
			if(input[0].equals("push")) {
				s.push(Integer.parseInt(input[1]));
			}
			else if(input[0].equals("pop")) {
				if(s.size()!=0)
					System.out.println(s.pop());
				else
					System.out.println(-1);
			}
			else if(input[0].equals("size")) {
				System.out.println(s.size());
			}
			else if(input[0].equals("empty")) {
				if(s.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else {					// top 명령
				if(s.size()!=0)
					System.out.println(s.peek());
				else
					System.out.println(-1);
			}
		}
	}
}