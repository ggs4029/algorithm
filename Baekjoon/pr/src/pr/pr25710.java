// 백준 25710번
// 길이가 N인 배열 a가 주어진다. 배열 a의 i번째 원소를 ai라고 정의하자.
// 다음 과정을 통해 배열에서 점수를 획득할 수 있다.
// 1. 배열의 두 원소 ai, aj를 선택한다. (1 ≤ i < j ≤ N)
// 2. 선택된 두 원소의 곱 ai ⨉ aj의 각 자릿수를 더한 값만큼 점수를 획득한다.
// 배열 a에서 획득할 수 있는 점수의 최댓값을 구하는 문제.
// 방법---------------------
// 첫 줄에 배열 a의 길이 n이 주어짐.
// 두번째 줄에 n개의 a의 원소들이 주어짐.
// 1 ≤ ai ≤ 999 임을 활용해 a = new int[1000] 로 만들고 중복 숫자가 있는지 검사.
// 중복 숫자가 있다면 배열리스트에 두번 저장해야함.
// 자릿수 구해가며 점수 최대값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class pr25710 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[1000];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[Integer.parseInt(input[i])] += 1;
		// 리스트 추가
		List<Integer> num = new ArrayList<>();
		for(int i=1; i<=999; i++) {
			if(a[i]==1)								// 중복 숫자 없으면 한번만 추가
				num.add(i);
			else if(a[i]>=2) {						// 중복 숫자 있으면 두번 추가
				num.add(i);
				num.add(i);
			}
		}
		// 점수 최댓값 구하기
		int output = 0;
		for(int i=0; i<num.size(); i++) {
			for(int j=i+1; j<num.size(); j++) {
				// 자릿수 합 구하기
				int tmp = num.get(i) * num.get(j);
				int sum = 0;						// 자릿수 합 저장할 변수 sum
				while(true) {
					sum += tmp % 10;
					tmp /= 10;
					if(tmp<=0)
						break;
				}
				output = Math.max(sum, output);
			}
		}
		// 출력
		System.out.print(output);
	}
}