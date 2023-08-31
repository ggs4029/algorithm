// 백준 1193번
// 분수찾기
// 무한히 큰 배열에 문제와 같이 분수들이 적혀있고
// 문제와 같이 지그재그 순서로 배열을 돈다고 하면 x번째 분수는 무엇인지 구하기
// 방법----------------------------
// 첫째줄에 x를 입력 받는다.
// 한번의 방향을 돌때 마다 추가되는 분수들은 n개이다. (n>=1인 정수)
// 따라서 지그재그 한줄의 분수들의 개수 또한 n개이다.
// 이 규칙과 중첩 반복문을 이용해 x번째 분수의 값을 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// x 입력받기
		int x = Integer.parseInt(br.readLine());
		int sum = 0;
		int count = 1;
		while(sum<x) { // x가 있는 범위까지만 작동
			if(sum+count>=x) { // x가 이 줄에 있으면
				if(count%2==0) { // 짝수줄인 경우
					for(int j=1; j<=count; j++) {
						if(j==x-sum) { // 인덱스 계산
							System.out.print(j);
							System.out.print("/");
							System.out.print(count+1-j);
						}
					}
				}
				else { // 홀수줄인 경우
					for(int j=1; j<=count; j++) {
						if(j==x-sum) { // 인덱스 계산
							System.out.print(count+1-j);
							System.out.print("/");
							System.out.print(j);
						}
					}
				}
			}
			sum+=count;
			++count;
		}
	}
}