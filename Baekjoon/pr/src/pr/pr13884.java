// 백준 pr13884번
// 삭삽 정렬로 배열을 정렬 할 때
// 가장 적게 삭삽 과정이 얼마나 수행되는지 출력하는 문제.
// 삭삽 정렬이 무엇인지는 문제 참고.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 p를 입력 받음.
// 각각의 테스트 케이스는 첫 줄에 데이터 세트의 번호인 k와 공백 이후 정렬 할 배열의 길이인 n이 주어짐.
// 그 이후 줄에서 배열의 원소 n개가 주어진다. (한 줄에 10개씩)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr13884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int p = Integer.parseInt(br.readLine());
		for(int i=0; i<p; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());					// 데이터 세트 번호
			int n = Integer.parseInt(st.nextToken());					// 배열 길이
			long[] num = new long[n];
			int tmp  = 0;
			while(tmp<n) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens() && tmp<n) {
					num[tmp] = Integer.parseInt(st.nextToken());
					tmp++;
				}
            }
			// 삭삽 정렬 최소 수행 횟수 구하기
			long[] copy = Arrays.copyOf(num, n);
			Arrays.sort(copy);
			int tmp2 = 0;
			for(int j=0; tmp2<n && j<n; j++) {
				if(copy[tmp2]==num[j])									// 이미 정렬되어 있는 부분만 골라내기
					tmp2++;
			}
			int output = n - tmp2;										// 정렬되어 있지 않은 부분만
			sb.append(k + " " + output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}