// 백준 1021번
// 회전하는 큐
// 방법----------------
// 첫 줄에 큐의 크기 n과 뽑아내려고 하는 수의 개수 m을 입력 받고
// 다음 줄에 뽑아내려고 하는 수의 위치들을 입력 받는다.
// for문을 m번 돌며 뽑고자 하는 원소의 인덱스를 이용해
// 인덱스가 큐의 가운데 원소보다 왼쪽에 있으면 2번 연산.
// 오른쪽에 있으면 3번 연산을 수행한다.
// 이때 2번, 3번 연산의 최솟값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class pr1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> input = new LinkedList<Integer>();
		for(int x=0; x<n; x++)
			input.add(x+1);
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<m; x++)
			arr[x] = Integer.parseInt(st.nextToken());
		// 원소 뽑기
		int sum = 0;
		for(int x=0; x<m; x++) {
			int index = input.indexOf(arr[x]);	// 뽑고자 하는 원소의 인덱스
			int half;							// 큐의 가운데
			if(input.size() % 2 == 1)			// 원소가 홀수개면
				half = input.size()/2;
			else								// 짝수개면
				half = input.size()/2-1;
			// 큐의 가운데 원소보다 왼쪽 or 정중앙에 있는 경우
			if(index <= half) {
				// 2번 연산 실행
				for(int y=0; y<index; y++) {
					int e = input.pollFirst();	// 맨앞 원소를 가져와
					input.offerLast(e);			// 맨뒤로 offer
					sum++;
				}
			}
			// 큐의 가운데 원소보다 오른쪽에 있는 경우
			else {
				// 3번 연산 실행
				for(int y=0; y<input.size()-index; y++) {
					int e = input.pollLast();	// 맨뒤 원소를 가져와
					input.offerFirst(e);		// 맨앞으로 offer
					sum++;
				}
			}
			input.pollFirst();					// 연산 후 원소 삭제
		}
		// 출력
		System.out.print(sum);
	}
}