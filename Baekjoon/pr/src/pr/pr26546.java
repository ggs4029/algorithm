// 백준 26546번
// String 클래스에는 substring이라는 함수가 존재.
// 이 문제는 substring 함수의 반대 작업을 하는 문제.
// 즉, 주어진 문자열에서 지정된 범위의 부분 문자열을 제거한 결과를 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 n이 주어짐.
// 그 후 n줄에 걸쳐 각 줄마다 문자열과 인덱스 i, j가 주어짐.
// (i,j) 앞뒤만 구해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int x=0; x<n; x++) {
			// 입력
			String[] input = br.readLine().split(" ");
			String s = input[0];
			int i = Integer.parseInt(input[1]);
			int j = Integer.parseInt(input[2]);
			String s2 = s.substring(0, i);
			String s3 = s.substring(j, s.length());
			// 출력
			System.out.println(s2+s3);
		}
	}
}