// 백준 13274번
// 사이즈 n인 수열에 k개의 쿼리를 처리할거임.
// l r x = 수열 오름차순 정렬 결과를 a[l] 부터 a[r]까지 x 더하고 다시 오름차순 정렬
// 모든 쿼리들을 순서대로 수행하고 수열 출력.
// 방법---------------------
// 첫 줄에 n과 k를 입력 받음.
// 다음 줄에 수열을 이루는 n개의 수들을 입력 받음.
// 셋째 줄부터 쿼리들 l r x가 한줄씩 주어짐.
// 원래 배열에서 x를 더할 구간과 그 구간 양쪽 두군데, 즉 세 구간으로 나눠
// x더하고 병합하는 과정을 거쳐 답 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr13274 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] num = new long[n];
		long[] tmp = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Long.parseLong(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 쿼리 처리
		for(int j=0; j<k; j++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			long x = Long.parseLong(st.nextToken());
			int left = l;									// 0 ~ l
			int midS = l;									// midS ~ r   --> x를 더할 구간
			int midE = r + 1;								// mindE ~ n-1
			int midLen = r - l + 1;
			// x 더하기
			int p = 0;
			int q = 0;
			int a = 0;										// 인덱스 옮기는 용으로 쓸 변수
			while(p<left && q<midLen) {
				long tmpL = num[p];
				long tmpM = num[midS + q] + x;
				if(tmpL <= tmpM) {
					tmp[a] = tmpL;
					a++;
					p++;
				}
				else {
					tmp[a] = tmpM;
					a++;
					q++;
				}
			}
			while(p < left) {
				tmp[a] = num[p];
				a++;
				p++;
			}
			while(q < midLen) {
				tmp[a] = num[midS + q] + x;
				a++;
				q++;
			}
			int tmpLen = a;
			// 원래 배열에 병합
			int p2 = 0;
			int r2 = midE;
			int b = 0;										// 인덱스 옮기는 용으로 쓸 변수
			while(p2<tmpLen && r2<n) {
				if(tmp[p2] <= num[r2]) {
					num[b] = tmp[p2];
					b++;
					p2++;
				}
				else {
					num[b] = num[r2];
					b++;
					r2++;
				}
			}
			while(p2 < tmpLen) {
				num[b] = tmp[p2];
				b++;
				p2++;
			}
			while(r2 < n) {
				num[b] = num[r2];
				b++;
				r2++;
			}
		}
		// 출력
		for(int i=0; i<n; i++) {
			sb.append(num[i]);
			if(i < n-1)
				sb.append(" ");
		}
		System.out.print(sb.toString().trim());
	}
}