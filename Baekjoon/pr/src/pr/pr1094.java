// 백준 1094번
// 64cm인 막대기를 반으로 나눠가며 Xcm 만들기
// 몇개의 막대기를 붙였나 구하는 문제
// 방법---------------
// x를 입력 받고
// 무한반복문을 돌리며 스틱이 x보다 크면 반으로 나누고
// 작으면 x에서 빼고 sum을 1 증가 시킨다.
// x가 0이되면 break하고 sum을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// x입력
		int x = Integer.parseInt(br.readLine());
		// 막대기의 개수 구하기
		int sum = 0;
		int wood = 64;
		while(true) {
			if(wood>x) // 막대기의 길이가 x보다 길면 반으로 나눔
				wood = wood/2;
			else {
				sum++;
				x = x-wood;
			}
			// x가 0이되면 반복문 탈출
			if(x==0)
				break;
		}
		// 출력
		System.out.print(sum);
	}
}