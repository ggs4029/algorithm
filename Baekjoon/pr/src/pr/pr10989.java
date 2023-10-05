// 백준 10989번
// 수 정렬하기 3
// 방법---------------
// Arrays.sort 이용시 시간 초과.
// Counting sort 를 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10000];
		for(int x=0; x<n; x++) { // 입력 받은 값의 인덱스를 1증가시킴
			count[Integer.parseInt(br.readLine())-1]++;
		}
		br.close();
		// 정렬
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<10000; x++) {
			while(count[x]>0) { // 다 출력하면 break하도록
				sb.append(x+1).append("\n");
				count[x]--;
			}
		}
		// 출력
		System.out.print(sb);
	}
}