// 백준 23757번
// n개의 선물 상자에 선물들이 담겨 있고
// m명의 아이들이 순서대로 현재 선물이 가장 많이 담겨있는 상자에서 각자 원하는 만큼 선물을 가져감.
// 상자에 자신이 원하는 것보다 적은 개수의 선물이 들어있다면, 선물을 가져가지 못해 실망.
// 한 명이라도 실망하지 않고 모두가 선물을 가져갈 수 있는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 선물 상자 수 n과 아이들 수 m을 입력 받음.
// 둘째 줄에 각 선물 상자에 들어있는 선물의 개수들을 입력 받음.
// 셋째 줄에 아이들의 번호 순으로 각 아이가 원하는 선물의 개수들을 입력 받음.
// 우선순위 큐를 사용해 실망하는 아이들이 있는지 체크하고 모든 아이들이 실망하지 않는지 결과를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr23757 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] gift = new int[100_001];
		int[] child = new int[100_001];
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			gift[i] = Integer.parseInt(st.nextToken());
			q.offer(gift[i]);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			child[i] = Integer.parseInt(st.nextToken());
		// 실망하는 아이들이 있는지 체크
		int output = 0;
		while(!q.isEmpty() && output<m) {
			int tmp = q.poll();
			if(tmp>=child[output]) {
				tmp -= child[output];
				output++;
				if(tmp!=0)
					q.add(tmp);
			}
			else if(tmp<child[output]) {								// 부족한 경우
				System.out.println(0);
				return;
			}
		}
		// 출력
		if (output==m)
			System.out.print(1);
		else
			System.out.print(0);
	}
}