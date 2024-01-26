// 백준 1015번
// 수열 정렬
// 주어진 배열을 정렬했을 때
// 그 수가 몇번째에 위치하는지 찾는 문제
// 방법-------------------------
// 배열의 크기 n과 배열의 원소들을 입력 받고
// 두개의 배열에 똑같이 저장한다.
// 하나는 그대로 두고 하나는 정렬한 뒤
// 두개의 배열을 비교하며 어떤 원소가 몇번째에 위치하고 있는지
// 순서대로 찾아 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];					// 입력 받은 배열
		int[] output = new int[n];					// 정렬할 배열
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<n; x++) {
			input[x] = Integer.parseInt(st.nextToken());
			output[x] = input[x];
		}
		// 정렬
		Arrays.sort(output);
		// 인덱스 찾기
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				if(input[x]==output[y]) {
					sb.append(y).append(" ");
					output[y] = 0;					// 중복 원소를 거르기 위해 append후 0으로 초기화
					break;
				}
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}