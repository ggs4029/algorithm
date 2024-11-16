// 백준 30489번
// 다운로드가 완료된 패키지가 m 개일 때, 전체 다운로드 진행률(%)의 최대치는 얼마일 수 있는지 구하는 문제.
// 참고: 다운로드가 "100%" 완료되었지만 아직 다운로드가 끝나지 않은 병렬 다운로드 중인 패키지가 존재할 수 있음.
// 다운로드가 완료된 m개의 패키지와 최대 k 개의 병렬 다운로드 중인 패키지에서 최대 진행률(%)을 소수점 4자리까지 출력.
// 방법---------------------
// 첫 줄에 n, m, k가 주어짐.
// n은 업그레이드 할 패키지의 수, m은 다운로드가 완료된 패키지의 수, k는 병렬로 다운로드 할 수 있는 패키지의 최대 수
// 둘째 줄에 n개의 수들이 주어짐. - 각 패키지의 크기.
// for문 통해 최대치 구하고 소수점 4자리까지만 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr30489 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input= br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int[] s = new int[n];
		String[] input2 = br.readLine().split(" ");
		long sum = 0;
		for(int i=0; i<n; i++) {
			s[i] = Integer.parseInt(input2[i]);
			sum += s[i];
		}
		// 정렬
		Arrays.sort(s);;
		// 최대치 구하기
		long max = 0;
		for(int i=0; i<m; i++)
			max += s[n-1-i]; 							// 가장 큰 m개의 패키지
		for(int i=0; i<k && m+i<n; i++)
			max += s[n-1-m-i]; 							// 병렬 다운로드 중인 k개 패키지
		double output = max / (double) sum * 100;
		// 출력
		System.out.printf("%.4f\n", output);
	}
}