// 백준 1269번
// 대칭 차집합
// 두 집합 사이의 차집합을 각각 구해서 그 수를 더해 출력하는 문제
// 방법---------------------------
// 집합a의 원소의 개수와 집합b의 원소의 개수를 한줄에 입력 받고
// 다음줄에 집합a의 원소들을, 그다음줄에 집합b의 원소들을 입력 받는다.
// 문제에서 요구한대로 해시셋을 이용하여 원소들을 저장한다.
// 차집합의 원소의 개수를 구하는 과정에서 집합의 객체들을 하나하나 순회해야 하는데
// Set에는 get()메소드가 없으므로 iterator()를 이용한다.
// 차집합의 원소의 개수들을 더해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class pr1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int a_length = Integer.parseInt(st.nextToken());
		int b_length = Integer.parseInt(st.nextToken());
		Set<Integer> a = new HashSet<>();					// 집합 a
		Set<Integer> b = new HashSet<>();					// 집합 b
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<a_length; x++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<b_length; x++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		// 차집합의 원소 개수 구하기
		int sum = 0;
		Iterator iter = a.iterator();
		// A-B
		for(int x=0; x<a_length; x++) {
			if(!b.contains(iter.next()))
				sum++;
		}
		// B-A
		Iterator iter2 = b.iterator();
		for(int x=0; x<b_length; x++) {
			if(!a.contains(iter2.next()))
				sum++;
		}
		// 출력
		System.out.print(sum);
	}
}