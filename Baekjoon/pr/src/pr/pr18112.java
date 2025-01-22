// 백준 18112번
// 이진수 게임은 주어진 ‘시작 이진수’를 몇 가지 동작으로 ‘목표 이진수’로 바꾸는 게임이다.
// 1. 한 자리 숫자를 보수로 바꾸기. 단, 맨 앞 숫자(Most Significant Digit)는 바꿀 수 없다.
// 2. 현재 수에 1 더하기.
// 3. 현재 수에서 1 빼기. 단, 현재 수가 0이라면 빼기가 불가능하다.
// 이 세가지 동작들을 할 수 있을 때,
// 방법---------------------
// 첫 줄에 길이 l의 시작 이진수가 주어짐.
// 두번째 줄에 길이 k인 목표 이진수가 주어짐.
// 세가지 동작들에 대해 나올 수 있는 결과들을 배열리스트로 만들어 리턴하도록 메소드 만들어 사용.
// bfs메소드로 이 동작들의 결과에 대해 그래프 탐색.
// 최소 동작 횟수를 출력.
// 오답노트------------------
// 배열 리스트를 사용하는 경우 결과가 중복되는 경우가 생길수 있으므로
// 해시셋을 이용.
// 동작 메소드에서 보수 바꾸기 부분 - 맨 앞 자리 제외한다는 조건 빠진거 채워넣기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class pr18112 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int input = Integer.parseInt(br.readLine(), 2);				// 2진수로 받아서 10진수로
		int output = Integer.parseInt(br.readLine(), 2);
		// 출력
		System.out.print(bfs(input, output));
	}

	// 게임에서 가능한 세가지 동작 메소드
	public static HashSet<Integer> move(int n) {
		HashSet<Integer> set = new HashSet<>();
		// 1. 한 자리 숫자 보수로 바꾸기 (맨 앞 자리 제외)
		for(int i=1; i<Integer.highestOneBit(n); i<<=1)
			set.add(n^i); 										// 비트 마스크로 xor 연산
		// 2. 1 더하기
		set.add(n+1);
		// 3. 1 빼기
		if(n>0)
			set.add(n-1);
		return set;												// 세가지 동작의 결과들을 배열리스트로 만들어 리턴
	}

	// bfs메소드
	public static int bfs(int input, int output) {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		q.add(input);
		visited.add(input);
		int sum = 0;
		if(input == output)											// 이미 같으면 0 리턴
			return 0;
		while(!q.isEmpty()) {
			int q_size = q.size();
			for(int i=0; i<q_size; i++) {
				int tmp = q.poll();
				if(tmp == output)
					return sum;
				for(int j : move(tmp)) {
					if(j>=0 && j<=1023 && !visited.contains(j)) {
						visited.add(j);
						q.add(j);
					}
				}
			}
			sum++;
		}
		return 1557;
	}
}