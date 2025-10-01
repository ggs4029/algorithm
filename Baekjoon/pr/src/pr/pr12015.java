// 백준 12015번
// 수열 a가 주어지면
// 가장 긴 증가하는 부분 수열의 길이를 출력하는 문제.
// 방법---------------------
// 첫 줄에 수열 a의 크기 n이 주어짐.
// 다음 줄에 수열 a를 이루고 있는 요소들이 한 줄에 주어짐.
// 이분 탐색하면서 증가하는 부분 수열에 마지막보다 현재 값(tmp)이
// 더 크면 추가하는 식으로 풀이.
// 오답노트------------------
// 수열을 정렬하고 시작하면 망함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 이분 탐색
		int output = 1;
		for(int i=1; i<n; i++) {
			int tmp = num[i];
			if(num[output-1] < tmp) {					// 지금 값이 수열 마지막보다 더 크면
				output++;								// 길이 늘리고
				num[output-1] = tmp;					// 마지막 수정
			}
			else {
				int min = 0;
				int max = output;
				while(min < max) {
					int mid = (min + max) / 2;
					if(num[mid] < tmp)
						min = mid + 1;
					else
						max = mid;
				}
				num[min] = tmp;
			}
		}
		// 출력
		System.out.print(output);
	}
}