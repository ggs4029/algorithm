// 백준 3052번
// 수를 10개 입력받은 뒤 이를 42로 나눈 나머지를 구해
// 서로 다른 값이 몇개 있나 구하는 문제
// 방법---------------------------------
// 길이10짜리 1차원 배열을 두개만듬
// 첫번째 배열에는 수를 입력받고
// 두번째 배열에는 이를 42로 나눈 나머지를 저장
// 두번째 배열을 for문 두개로 순회하며 중복검사
// 중복검사는 한 값에 대해 순회할때 중복값이 있으면 뒤의 값을 -1로 바꾸는 식으로

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1차원 배열 두개 생성 and 입력 받기
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		for(int x=0; x<arr1.length; x++) {
			arr1[x] = Integer.parseInt(br.readLine());
		}
		// 두번째 배열에 43로 나눈 수를 저장
		for(int x=0; x<arr2.length; x++) {
			arr2[x] = arr1[x]%42;
		}
		// 중복검사 후 나머지가 몇개 있나 산출
		int sum = 0;
		for(int x=0; x<arr2.length; x++) {
			int a = arr2[x];
			if(a!=-1) {
				for(int y=x; y<arr2.length; y++) {
					if(arr2[y]==a)
						arr2[y] = -1;
				}
				sum++;
			}
		}
		// 출력
		System.out.print(sum);
	}
}
