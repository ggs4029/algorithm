// 백준 11582번
// N개의 치킨의 수치를 무작위로 놓은 뒤 N/2명의 C.T.P 회원이 차례대로 2개의 치킨집을 선택해  정렬을 한다.
// 그 뒤 N/4명이 차례대로 바로 전 단계의 사람이 정렬한 두 개의 그룹을 차례대로 선택 하여 치킨집을 정렬을 한다.
// 계속해서 N/8명, N/16명이 정렬을 진행하다가 마지막 사람이 두 개의 정렬된 그룹을 합병하여 작업을 완료한다.
// 작업을 진행하던 중 문득 민호는 작업의 중간단계가 궁금해졌다.
// 현재 단계에서 k명의 회원이 정렬을 진행할 때 정렬을 마친 뒤 결과를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 둘째 줄에 치킨집의 맛 수치들이 주어지고
// 셋째 줄에 k가 주어짐.
// for문으로 l/k 크기만큼 순회하며 그룹끼리 정렬해주고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr11582 {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int l = Integer.parseInt(br.readLine());
		int[] num = new int[l];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<l; i++)
			num[i] = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int tmp = l / k;								// 그룹 크기
		for(int i=0; i<l; i+=tmp)
			Arrays.sort(num, i, i + tmp);				// 그룹끼리 정렬
		// 출력
		for(int i : num)
			sb.append(i+ " ");
		System.out.print(sb.toString().trim());
	}
}