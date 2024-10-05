// 백준 26145번
// 운영자가 얼마를 받게되는지 문제의 조건에 따라서 계산하는 문제.
// 방법---------------------
// 첫 줄에 출제자와 검수자의 수 n, m을 입력 받음.
// 둘째 줄에 출제자 n명이 받은 출제비를 한 줄에 입력 받음.
// 셋째 줄부터 n줄에 걸쳐 운영자에게 자유롭게 나눠주기로 한 돈을 한 줄에 입력 받음.
// 돈 계산 후 각 운영자가 받게 되는 돈을 차례로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26145 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 줄 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		// 둘째 줄 입력
		int[] money = new int[n+m];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			money[i] = Integer.parseInt(input2[i]);
		}
		// 나머지 입력
		for(int i=0; i<n; i++) {
			String[] input3 = br.readLine().split(" ");
			for(int j=0; j<n+m; j++) {
				// 돈 계산
				money[i] -= Integer.parseInt(input3[j]);
				money[j] += Integer.parseInt(input3[j]);
			}
		}
		//출력
		for(int i=0; i<money.length; i++) {
			System.out.print(money[i]+" ");
		}
	}
}