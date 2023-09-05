// 백준 5073
// 세 변의 길이를 입력 받아
// 어떤 종류의 삼각형인지 출력하는 문제
// 방법----------------------
// while문을 돌며 매번 한 줄에 세 변을 입력 받고
// 세 변의 길이가 삼각형의 조건을 충족하는지 if문을 통해 알아내고
// 만족한다면 어떤 삼각형인지 if문을 통해 알아내 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr5073 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 입력
			String[] input = br.readLine().split(" ");
			int[] tri = new int[3];
			tri[0]= Integer.parseInt(input[0]);
			tri[1]= Integer.parseInt(input[1]);
			tri[2]= Integer.parseInt(input[2]);
			Arrays.sort(tri);
			if(tri[0]==0 && tri[1]==0 && tri[2]==0) // 셋다 0이면 마지막줄
				break;
			// 출력
			if(tri[0]+tri[1]<=tri[2]) // 삼각형의 조건을 충족하는지
				System.out.println("Invalid");
			else { // 충족한다면 어떤 삼각형인지
				if(tri[0]==tri[1] && tri[0]==tri[2] && tri[1]==tri[2])
					System.out.println("Equilateral");
				else if(tri[0]!=tri[1] && tri[0]!=tri[2] && tri[1]!=tri[2])
					System.out.println("Scalene");
				else
					System.out.println("Isosceles");
			}
		}
	}
}