// 백준 10815번
// 정수 n개를 입력 받고
// 정수 m개를 입력 받아
// m개의 수에 대해 n에 이 수들이 있는지 출력하는 문제
// 방법---------------------
// 첫째 줄에 n, 둘째 줄에 n개의 카드에 적혀 있는 수들을 입력 받고
// 셋째 줄에 m, 넷째 줄에 m개의 정수들을 입력 받는다.
// Arrays.binarySearch를 이용해
// 값이 있으면 1 없으면 0을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n입력
		int n = Integer.parseInt(br.readLine());
		String[] inputN = br.readLine().split(" ");
		int[] arrN = new int[n];
		for(int x=0; x<n; x++)
			arrN[x] = Integer.parseInt(inputN[x]);
		// m입력
		int m = Integer.parseInt(br.readLine());
		String[] inputM = br.readLine().split(" ");
		int[] arrM = new int[m];
		for(int x=0; x<m; x++)
			arrM[x] = Integer.parseInt(inputM[x]);
		// 출력
		Arrays.sort(arrN); // 이진탐색을 당할 배열은 항상 순서대로 정렬 되어 있어야
		for(int x=0; x<arrM.length; x++) {
			if(Arrays.binarySearch(arrN, arrM[x])>=0)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}
	}
}