// 백준 25556번
// 길이 n인 순열 a와 네 개의 비어있는 스택이 있음.
// 순열을 청소하려함. (청소가 무엇인지는 문제 참조)
// 주어진 순열이 청소 가능한지 판별하는 문제.
// 방법---------------------
// 첫 줄에 순열 길이 n이 주어짐.
// 다음 줄에 순열a의 원소 ai들이 한 줄에 주어진다.
// 스택 네개 만들고 각 스택에 들어있는 숫자들보다 큰 숫자가 들어올때만 push해서
// 스택 짜서 이것이 가능하면 yes 어느 곳에도 못들어가면 no출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr25556 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		Stack<Integer> s4 = new Stack<>();
		s1.push(0);												// 스택 빈거 체크용
		s2.push(0);
		s3.push(0);
		s4.push(0);
		// 청소 가능한지 판별
		Stack<Integer>[] stacks = new Stack[]{s1, s2, s3, s4};
		for(int i : num) {
			boolean tmp = false;
			for(Stack<Integer> s : stacks) {
				if(s.peek() < i) {								// 맨 앞꺼보다 i가 더 크면
					s.push(i);
					tmp = true;
					break;
				}
			}
			if(!tmp) {
				sb.append("NO");
				break;
			}
		}
		// 출력
		if(sb.isEmpty())
			System.out.print("YES");
		else
			System.out.print(sb.toString().trim());
	}
}