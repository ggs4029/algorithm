// 백준 26168번
// 크기 n인 배열a가 주어짐.
// 배열에는 같은 값을 갖는 원소가 여러 개 존재할 수 있다. 배열 a에 대한 m개의 질의가 저장된 배열 b가 주어진다.
// 배열 b에 저장된 m개의 질의는 아래 세 가지 유형으로 구분된다.
// 각 유형에 대한 설명은 문제 참조.
// 배열 b에 저장된 첫 번째 질의부터 m번째 질의까지 순서대로 처리하면서 질의 결과를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 m이 주어짐.
// 둘째 줄에 배열 a의 원소들이 주어짐.
// 그 다음 줄부터 m줄에 걸쳐 배열 b에 저장된 질의들의 유형이 주어진다.
// 크거나 같은 원소의 인덱스를 찾도록 이분 탐색 메소드 살짝 만지기.
// 유형 별로 처리하고 출력하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr26168 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] a = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Long.parseLong(st.nextToken());
		// 정렬
		Arrays.sort(a);
		// 질의
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp==1) {										// 유형 1
				long k = Long.parseLong(st.nextToken());
				sb.append(a.length - bs(a, k)).append("\n");	// k보다 크거나 같은 원소 개수
			}
			else if(tmp==2) {									// 유형 2
				long k = Long.parseLong(st.nextToken());
				sb.append(a.length - bs(a, k+1)).append("\n");	// k보다 큰 원소 개수
			}
			else {												// 유형 3
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				sb.append(bs(a, y+1)- bs(a, x)).append("\n");	// x보다 크거나 같고 y보다 크거나 작은 원소 개수
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 이분 탐색 메소드 - 크거나 같은 원소 인덱스 찾기
	public static int bs(long[] arr, long target) {
		int low = 0;
		int high = arr.length;
		while(low<high) {
			int mid = (low + high) / 2;
			if(arr[mid]<target)
                low = mid + 1;
			else
                high = mid;
		}
		return low;
	}
}