// 백준 18870번
// 좌표 압축
// 좌표에 순위 붙이기(동일한 값이 있는 경우 동일 순위)
// 방법------------------
// n과 n개의 좌표를 입력 받는다.
// 입력 받은 좌표들을 arr, arr2 배열에 넣고
// arr2 배열을 Arrays.sort() 한다.
// 정렬된 배열을 기준으로 Map을 활용해
// 좌표값에 따른 순위를 붙여 저장한다.
// 출력할때는 정렬하지않은 기존(original)배열의 값을 map.get()에 넣어
// 순위를 출력한다.
// 출력은 시간 초과 때문에 StringBuilder를 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pr18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		long[] arr = new long[n];					// 기존(original) 배열
		long[] arr2 = new long[n];					// 정렬할 배열
		for(int x=0; x<n; x++) {
			arr[x] = arr2[x] = Integer.parseInt(input[x]);
		}

		// 정렬
		Arrays.sort(arr2);
		long i = 0;									// 순위
		Map<Long, Long> map = new HashMap<>();
		for(int x=0; x<n; x++) {
			if(!map.containsKey(arr2[x])) {			// 안에 없는 좌표값이면
				map.put(arr2[x], i);				// 좌표값과 순위를 저장
				i++;								// 그다음 순위 증가
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<n; x++) {
			sb.append(map.get(arr[x])).append(' ');
		}
		System.out.print(sb.toString());
	}
}