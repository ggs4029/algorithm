// 백준 4153번
// 삼각형의 세변의 길이가 주어지면 직각삼각형인지 판별하기
// 방법---------------------
// 0 0 0이 입력되기 전까지 무한루프를 돌며 한 줄에 삼각형 세변의 길이를 입력 받음
// 피타고라스의 정리와 삼각형의 성립 조건을 만족하는지 검사하며 판별 결과를 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 입력
			String[] input = br.readLine().split(" ");
			int[] tri = new int[3];
			tri[0] = Integer.parseInt(input[0]);
			tri[1] = Integer.parseInt(input[1]);
			tri[2] = Integer.parseInt(input[2]);
			// 테스트 종료 검사
			if(tri[0]==0 && tri[1]==0 && tri[2]==0) {
				break;
			}
			// 정렬
			Arrays.sort(tri);
			// 검사 + 출력
			if(tri[0]+tri[1]<=tri[2])								// 삼각형인지
				System.out.println("wrong");
			else if(tri[0]*tri[0]+tri[1]*tri[1] != tri[2]*tri[2])	// 피타고라스
				System.out.println("wrong");
			else
				System.out.println("right");
		}
	}
}