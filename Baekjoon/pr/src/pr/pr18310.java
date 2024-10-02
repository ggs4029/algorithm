// 백준 18310번
// 일직선 상의 마을에서 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록 설치하려고 할 때
// 안테나를 설치할 위치의 값을 출력하는 문제
// 방법---------------------
// 첫 줄에 집의 수 n을 입력 받고
// 다음 줄에 집들의 위치를 한 줄에 입력 받는다. (1<=n<=200,000)
// 그냥 가운데집 아닌가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr18310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] house = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(house);
		// 출력
		if(n%2==0)
			System.out.print(house[house.length/2-1]);
		else
			System.out.print(house[house.length/2]);
	}
}