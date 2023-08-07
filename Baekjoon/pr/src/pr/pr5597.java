// 백준 5597번
// 출석번호가 30번까지 있음
// 과제는 28명만 제출하였음
// 제출 안한 학생을 찾기 (낮은 순으로)
// 방법----------------------------
// 길이30의 1차원 배열을 만들고 1~30까지의 숫자를 넣음
// for문을 돌며 입력 받은 출석번호의 값을 0으로 만듬
// 그뒤 다시 for문을 돌며 0이아닌 값을 출력

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1차원 배열 생성과 초기화
		int[] student = new int[30];
		for(int x=1; x<=student.length; x++) {
			student[x-1] = x;
		}
		// 입력 받기 + 배열순회
		for(int x=0; x<28; x++) {
			int input = Integer.parseInt(br.readLine());
			student[input-1] = 0;
		}

		// 과제 제출을 하지않은 학생의 출석번호 출력
		for(int x=0; x<student.length; x++) {
			if(student[x]!=0)
				System.out.println(student[x]);
		}
	}
}
