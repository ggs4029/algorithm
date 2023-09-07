// 백준 2751번
// N개의 수가 주어지면
// 이를 오름차순으로 정렬하는 문제
// 방법-----------------------
// 첫째 줄에 N을 입력 받고
// 둘째 줄부터 N줄에 걸쳐 수를 입력 받고
// 이를 오름차순 정렬해 N줄에 걸쳐 출력한다.
// Arrays.sort()를 쓰면 시간초과가 되므로 Collections.sort()를 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pr2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> input = new ArrayList<>();
		// 입력
		for(int x=0; x<n; x++) {
			input.add(Integer.parseInt(br.readLine()));
		}
		// 정렬
		Collections.sort(input);
		// 최종 출력
		StringBuilder output = new StringBuilder();
		for(int i : input) {
			output.append(i).append("\n");
		}
		System.out.print(output);
	}
}