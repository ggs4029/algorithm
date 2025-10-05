// 백준 19599번
// 서로 다른 정수가 오름차순으로 정렬된 크기가 n인 배열 a가 있음.
// 이진 탐색, 삼진 탐색으로 배열 a의 i번째 원소 ai를 찾을 때,
// ai를 찾기 전에 참조해야 하는 배열 a의 원소 개수를 각각 bi , ti 라고 함.
// bi값이 ti값보다 작은 배열 a의 원소의 개수,
// bi값과 ti값이 같은 배열 a의 원소의 개수,
// bi값이 ti값보다 큰 배열 a의 원소의 개수를 순서대로 각각 한줄씩 출력하는 문제.
// 방법---------------------
// 첫 줄에 배열의 크기 n을 입력 받음.
// 이진, 삼진 탐색 알고리즘은 문제에 나와있는 코드를 가져다 사용.
// 참조해야 하는 배열 a의 원소 개수들을 세고 0~n까지 순회하면서
// bi가 더 작은 경우, 큰 경우, 같은 경우 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19599 {
	public static int n;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		n = Integer.parseInt(br.readLine());
		int bi = 0;
		int ti = 0;
		int draw = 0;
		// 참조 횟수 세기
		for(int i=0; i<n; i++) {
			int tmp1 = binarySearch(i);
			int tmp2 = ternarySearch(i);
			if(tmp1 < tmp2)
				bi++;
			else if(tmp1 == tmp2)
				draw++;
			else
				ti++;
		}
		sb.append(bi).append("\n");
        sb.append(draw).append("\n");
        sb.append(ti);
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 이진 탐색에서 계산 메소드
	public static int binarySearch(int value) {
		int left = 0;
		int right = n - 1;
		int sum = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(mid == value)
				break;
			sum++;											// 찾는 값이 아니면 참조함
			if(value < mid)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return sum;
	}

	// 삼진 탐색에서 계산 메소드
	public static int ternarySearch(int value) {
		int left = 0;
		int right = n - 1;
		int sum = 0;
		while(left <= right) {
			int leftThird = left + (right - left) / 3;
			int rightThird = right - (right - left) / 3;
			if(leftThird == value) {
				break;
			}
			sum++;											// 왼쪽에서 찾는 값 아니면 참조
			if(rightThird == value) {
				break;
			}
			sum++;											// 오른쪽에서 찾는 값 아니면 참조
			if(value < leftThird)
				right = leftThird - 1;
			else if(value < rightThird) {
				left = leftThird + 1;
				right = rightThird - 1;
			}
			else
				left = rightThird + 1;
		}
		return sum;
	}
}