// 백준 2217번
// n개의 로프가 있음. 이 로프를 이용해 물체를 들어올릴 수 있다.
// 각각의 로프는 굵기나 길이가 달라 들 수 있는 물체의 중량이 서로 다름.
// 여러 로프를 병렬로 연결하면 로프게 걸리는 중량을 나눌 수 있음.
// k개의 로프를 사용해 중량 w인 물체를 들 때, 각 로프에는 고르게 w/k 만큼의 중량이 걸림.
// 각 로프들에 대한 입력이 주어지면 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구하는 문제.
// 방법---------------------
// 첫 줄에 로프 개수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 각 로프가 견디는 최대 중량이 주어진다.
// 입력 받은거 배열로 받고 내림차순 정렬.
// 정렬된 배열가지고 하나씩 로프 꺼내가면서 견딜 수 있는 중량의 최댓값 갱신.
// 최댓값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class pr2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[n];
		for(int i=0; i<n; i++)
			rope[i] = Integer.parseInt(br.readLine());
		// 내림차순 정렬
		Arrays.sort(rope, Collections.reverseOrder());
		// 최대 중량 구하기
		int output = 0;
		for(int i=0; i<n; i++)
			output = Math.max(output, rope[i] * (i + 1));	// 로프 하나씩 꺼내가며 최대 중량 구하기
		// 출력
		System.out.print(output);
	}
}