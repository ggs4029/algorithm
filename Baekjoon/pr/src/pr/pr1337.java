// 백준 1337번
// 올바른 배열이란 어떤 배열 속에 있는 원소 중 5개가 연속적인 것을 말한다.
// 예를 들어 배열 {6, 1, 9, 5, 7, 15, 8}.
// 배열이 주어지면, 이 배열이 올바른 배열이 되게 하기 위해서 추가되어야 할 원소의 개수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 배열의 크기 n이 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 배열의 원소들이 하나씩 주어진다.
// 배열리스트와 배열을 이용해 배열리스트의 각 원소마다
// 올바른 배열이 되기 위해 추가해야 할 값의 개수를 이중for으로 탐색하며 모두 구하고
// 그 값들을 저장한 배열에서 최솟값을 찾아 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pr1337 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=0; i<n; i++)
			num.add(Integer.parseInt(br.readLine()));
		// 정렬
		Collections.sort(num);
		// 올바른 배열에 필요한 원소 개수 세기
		int[] tmp = new int[n];						// tmp[i] = num의 i번째 원소가 올바른 배열이 되기 위해 추가해야할 원소의 개수
		for(int i=0; i<n; i++) {
			for(int j=1; j<=4; j++) {
				if(!num.contains(num.get(i)+j)) {	// 연속되는 값이 없으면
					tmp[i]++;
				}
			}
		}
		// 최솟값 구하기
		int output = 1557;
		for(int i : tmp) {
			if(i<output)
				output = i;
		}
		// 출력
		System.out.print(output);
	}
}