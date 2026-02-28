// 백준 24090번
// n개의 서로 다른 양의 정수가 저장된 배열 a가 있음.
// 퀵 정렬로 배열 a를 오름차순 정렬할 경우 배열 a에
// k번째 교환되는 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 배열 a의 크기 n과 교환 횟수 k가 한 줄에 주어짐.
// 다음 줄에 배열 a의 원소들이 한 줄에 주어진다.
// 퀵 정렬, 파티션 메소드는 문제에 주어진 코드를 사용해 구현하고
// k번째에 교환되는 두 수만 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr24090 {
	public static int sum = 0;
    public static int k = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		// 퀵정렬
		quickSort(a, 0, n-1);
		// 출력
		if(sum < k)
			System.out.print(-1);
	}

	// 퀵 정렬 메소드
	public static void quickSort(int[] a, int p, int r) {
		if(p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}

	// 분할 메소드
	public static int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for(int j=p; j<r; j++) {
			if(a[j] <= x) {
				i++;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				sum++;
				if(sum == k)
					System.out.print(a[i] + " " + a[j]);
			}
		}
		if(i+1 != r) {
			int tmp = a[i+1];
			a[i+1] = a[r];
			a[r] = tmp;
			sum++;
			if(sum == k)
				System.out.print(a[i+1] + " " + a[r]);
		}
		return i + 1;
	}
}