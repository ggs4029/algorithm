// 백준 31796번
// 데이터베이스의 책들을 규칙에 따라 진열할거임.
// 웹사이트 한 페이지에 책을 한 종류 이상 진열해야하고
// 가격이 두 배 이상 차이 나는 책을 한 페이지에 함께 진열할 수 없음.
// 책이 진열될 페이지를 최소화하기로 하였을 때, 최소 페이지 수 출력하는 문제.
// 방법---------------------
// 첫 줄에 책 개수 n이 주어짐.
// 다음 줄에 책의 가격을 한 줄에 입력 받음.
// 입력 받은 책 가격들 정렬하고
// 페이지에 최대한 많은 책을 진열하도록 구현.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr31796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] book = new int[n];
		for(int i=0; i<n; i++)
			book[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(book);
		// 책 진열하기
		int page = 1;
		int min = book[0];
		for(int i=1; i<n; i++) {
			int tmp = book[i];
			if(2*min <= tmp) {							// 두배 차이 이상이면
				page++;									// 게시 같이못함
				min = tmp;
			}
		}
		// 출력
		System.out.print(page);
	}
}