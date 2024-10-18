// 백준 2108번
// n개의 수의 산술평균, 중앙값, 최빈값, 범위를 출력하는 문제
// 주의! - n은 항상 홀수로 주어짐
// 방법---------------------
// 첫 줄에 개수 n을 입력 받고 다음 줄부터 n줄에 걸쳐 수를 입력 받는다.
// 산술평균 = 소수점 첫째 자리에서 반올림 해 출력.
// 중앙값 = 정렬 후 가운데 인덱스의 배열값 출력
// 최빈값 = 최빈값이 여러개면 최빈값 중 두번째로 작은 값을 출력하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 산술평균 + 출력
		double sum = 0;
		for(int i=0; i<n; i++)
			sum += num[i];
		System.out.println((int) Math.round(sum/n));
		// 중앙값 + 출력
		System.out.println(num[n/2]);
		// 최빈값 + 출력
		int tmp = 0; 										// 빈도를 세기 위한 변수
		int max = Integer.MIN_VALUE; 						// 최빈값 저장을 위한 변수
		int mode = num[0];
		boolean tmp2 = false; 								// 첫번째 최빈값인지 두번째인지 판별을 위한 변수
		for(int i=0; i<n-1; i++) {
			if(num[i]==num[i+1])
				tmp++;
			else
				tmp = 0;
			if(max<tmp) {
				max = tmp;
				mode = num[i];
				tmp2 = true;
			}
			else if(max==tmp && tmp2==true) {
				mode = num[i];
				tmp2 = false;
			}
		}
        System.out.println(mode);
		// 범위 + 출력
		System.out.print(num[n-1]-num[0]);
	}
}