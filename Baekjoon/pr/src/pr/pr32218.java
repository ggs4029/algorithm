// 백준 32218번
// 준세의 문제 풀기.
// 준세가 만든 규칙의 과정을 반복하였을 때, 준세가 언제 잠들 수 있는지 구하는 문제.
// 방법---------------------
// 첫 줄에 배열 길이 n 주어짐.
// 두번째 줄에 배열 나타내는 n개의 정수가 한 줄에 주어짐.
// 무한 반복 하면서 a, b가 동일해질때까지 규칙에 따라 b배열을 만듦.
// 언제 잠들 수 있는지 카운트하고 출력.
// 잠들지 못하는 경우는 없음.
// 루프를 돌면서 매번 0이 아닌 마지막 요소가 0으로 바뀌기 때문.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr32218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(input[i]);
		// 준세의 규칙 반복하기
		int output = 0;
		while(true) {
			output++;
			for(int i=0; i<n; i++) {
				// 더 큰 원소 몇개인지 구하고 tmp에 담아 b 배열에 기록
				int tmp = 0;
				for(int j=i+1; j<n; j++) {
					if(a[i]<a[j])
						tmp++;
				}
				b[i] = tmp;
			}
			// 동일한 배열인지 검사
			if (Arrays.equals(a, b))
                break;
			System.arraycopy(b, 0, a, 0, n);
		}
		// 출력
		System.out.print(output);
	}
}