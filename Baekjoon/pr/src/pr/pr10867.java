// 백준 10867번
// n개 정수들 입력 받고 중복 제거해서 오름차순으로 정렬 출력하기.
// 방법---------------------
// 첫 줄에 n 입력 받고
// 그 다음줄에 정수들 n개 한 줄에 입력 받음.
// 해시셋으로 저장해서 중복 제거하고 배열로 다시 만들어서 정렬하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class pr10867 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> h = new HashSet<Integer>();
		for(int i=0; i<n; i++)
			h.add(Integer.parseInt(st.nextToken()));
		// 정렬
		ArrayList<Integer> num = new ArrayList<Integer>(h);
		Collections.sort(num);
		for(int i : num)
			sb.append(i).append(" ");
		// 출력
		System.out.print(sb.toString().trim());
	}
}