// 백준 1174
// 줄어드는 수
// 숫자 n을 입력 받고 n번째 줄어드는 수를 구하는 문제
// 방법-----------------------
// n을 입력 받고 깊이 우선 탐색을 통해
// 모든 줄어드는 수를 리스트에 추가한다.
// 리스트를 sort하여 n번째 수를 찾아 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class pr1174 {
	static int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };	// 거꾸로 만든 숫자 배열
	static List<Long> output = new ArrayList<>();			// 줄어드는 수를 저장할 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 연산
		dfs(0,0);
		// 정렬
		output.sort(null);
		// 출력
		if(n>1023)									// 줄어드는 수가 존재하지 않는 경우
			System.out.print(-1);
		else
			System.out.println(output.get(n-1));
	}

	// 깊이 우선 탐색
	public static void dfs(long n, int i) {
		// n은 number(현재 숫자), i는 index
		// 스택에 없는 줄어드는 수면 추가
		if(!output.contains(n))
			output.add(n);

		// index가 10을 넘어가면 종료 = num배열의 크기가 10
		// 제일 큰 줄어드는 수가 9876543210이므로
		if(i>=10)
			return;

		// 지금 수에 다음 자리수 추가해서 호출
		dfs(n*10+num[i], i+1);
		// 지금 수를 고르지않고 다른수를 선택하기 위한 호출
		dfs(n, i+1);
	}
}