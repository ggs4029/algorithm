// 백준 1026번
// 보물
// 두 배열에서 원소들을 각각 하나씩 뽑아 곱한 값을 모두 더하고
// 그 합이 최소가 되게 만들려고 할 때, 그 최솟값을 출력하는 문제
// 방법---------------
// 배열의 길이인 n을 첫째 줄에 입력 받고
// 그 다음줄부터 두줄에 걸쳐 배열 a와 b를 입력 받는다.
// 곱셈의 합을 최소로 만드려면 a의 원소 중 제일 작은 값을
// b의 원소 중 제일 큰 값이랑 곱하게 만들면 되므로
// 배열 a는 오름차순으로 정렬하고
// 배열 b는 내림차순으로 정렬한다. (실제로는 오름차순으로 정렬하고 곱할때 맨 뒤 원소부터 곱셈)
// 배열 a의 맨 처음과 배열 b의 맨 뒤에서부터 곱해가며
// 곱셈의 합들을 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int x=0; x<n; x++)
			a[x] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] b = new int[n];
		for(int x=0; x<n; x++)
			b[x] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(a);
		Arrays.sort(b);
		// 합들의 최솟값 구하기
		int sum = 0;
		for(int x=0; x<n; x++) {
			sum += a[x] * b[n-x-1];
		}
		// 출력
		System.out.print(sum);
	}
}