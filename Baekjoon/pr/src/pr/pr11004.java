// 백준 11004번
// 배열을 오름차순 정렬하고 k번째 수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 배열 크기 n과 k를 입력 받음.
// 다음 줄에 배열의 요소들이 한 줄에 주어짐.
// 리스트로 입력 받고 k번쨰 수 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class pr11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> a = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a.add(Integer.parseInt(st.nextToken()));
		// 정렬
		Collections.sort(a);
		// 출력
		System.out.print(a.get(k-1));
	}
}