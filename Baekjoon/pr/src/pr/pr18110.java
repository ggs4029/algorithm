// 백준 18110번
// 사용자들이 어떤 문제에 제출한 난이도 의견 목록이 주어지면
// solved.ac가 결정한 문제의 난이도를 계산하는 문제
// 방법---------------------
// 첫 줄에 난이도 의견의 개수 n을 입력 받음
// 다음 줄부터 n줄에 걸쳐 제출한 난이도 의견들을 입력 받음.
// 문제에서 주어진대로(절사평균) 난이도를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr18110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] level = new int[n];
		for(int i=0; i<n; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		Arrays.sort(level);
		// 절사평균에서 제외되는 사람 수 구하기
		int tmp = (int) Math.round(n*0.15);
		// 난이도 구하기
		int sum = 0;
		for(int i=tmp; i<n-tmp; i++)
			sum += level[i];
		int output = (int) Math.round((double) sum/(n-2*tmp));
		// 출력
		System.out.print(output);
	}
}