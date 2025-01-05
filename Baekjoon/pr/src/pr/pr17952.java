// 백준 12865번
// 문제에서 주어진 방법대로 과제들을 수행했을 때
// 최종적으로 받게 되는 과제 점수를 예상해서 출력하는 문제.
// 규칙은 문제 참고.
// 방법---------------------
// 첫 줄에 이번 학기가 몇 분인지 n을 입력 받음.
// 두번째 줄부터 n줄에 걸쳐 과제의 정보가 주어진다.
// 스택과 과제 클래스를 구현해 사용, 결과를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr17952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		Stack<Hw> stack = new Stack<>();
		int output = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			if(input!=0) {
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				stack.push(new Hw(a, t));
			}
			// 하던 과제가 있으면
			if(!stack.isEmpty()) {
				Hw tmp = stack.peek();
				int hwTime = tmp.getTime() - 1;							// 시간 -1
				if(hwTime==0) {											// 과제 다했으면
					output += tmp.getScore();							// 점수 추가하고 pop
					stack.pop();
				}
				else {													// 다못했으면
					stack.pop();										// 하던거 pop하고 새롭게 push
					stack.push(new Hw(tmp.getScore(), hwTime));
				}
			}
		}
		// 출력
		System.out.print(output);
	}

	// 숙제 클래스
	public static class Hw {
		int score;
		int time;

		public Hw(int score, int time) {
			this.score = score;
			this.time = time;
		}

		public int getScore() {
			// TODO Auto-generated method stub
			return this.score;
		}

		public int getTime() {
			// TODO Auto-generated method stub
			return this.time;
		}
	}
}