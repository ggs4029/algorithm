// 백준 13334번
// 양의 정수 d와 정수쌍 n개가 주어지면
// 길이 d의 모든 선분 L에 대하여, 집과 사무실의 위치가 모두 L에 포함되는 사람들의 최대 수를 구하는 문제.
// 정수쌍 n개는 사람들의 사람i의 집과 사무실의 위치임.
// 방법---------------------
// 첫 줄에 사람수 n 입력 받고
// 다음 줄부터 n줄에 걸쳐 집과 사무실 위치 정수쌍 입력 받고
// 막줄에 철로 길이 d 입력 받음.
// 집이나 사무실 중 오른쪽에 있는 값 기준으로 정렬하고
// 정수쌍 순회하며 제일 많이 겹치는 값 갱신하고 출력.
// 오답노트------------------
// q.peek() 하기 전에 큐가 비어있는지 검사해야함.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr13334 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> p = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int house = Integer.parseInt(st.nextToken());
			int company = Integer.parseInt(st.nextToken());
			p.add(new Person(Math.min(house, company), Math.max(house, company)));
		}
		int d = Integer.parseInt(br.readLine());
		// 정렬 - 오른쪽 값 기준
		Collections.sort(p);
		// 철로에 포함되는 최대 사람수 구하기
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int tmp = 0;
		int output = 0;
		for(Person i : p) {
			while(!q.isEmpty()&&q.peek() < i.right-d) {		// 왼쪽값이 범위 밖이면
				q.poll();									// 버림
				tmp--;
			}
			if(i.left >= i.right-d) {
				q.add(i.left);
				tmp++;
			}
			output = Math.max(output, tmp);
		}
		// 출력
		System.out.print(output);
	}

	// 사람 클래스
	public static class Person implements Comparable<Person> {
        int left;
        int right;

		Person(int x, int y) {
        	left = x;
        	right = y;
        }

		// end값 기준으로 정렬하는 메소드
        @Override
        public int compareTo(Person p) {
            return Integer.compare(this.right, p.right);
        }
	}
}