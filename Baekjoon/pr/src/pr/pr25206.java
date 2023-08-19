// 백준 25206번
// 학점 평점 출력하기
// 전공평점 = (학점 X 과목평점) 의 합/ 학점의 총합
// 방법-----------------------------
// 과목명, 학점, 등급을 20줄에 걸쳐 입력 받고
// 학점 x 과목평점 을 다 합친 후 학점의 총합으로 나눈 뒤 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr25206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		double score=0; // 학점 x 과목평점의 합
		double grades=0; // 학점의 합
		for(int x=0; x<20; x++) {
			String[] input = br.readLine().split(" ");
			switch (input[2]) {
			case "A+":
				input[2] = "4.5";
				break;
			case "A0":
				input[2] = "4.0";
				break;
			case "B+":
				input[2] = "3.5";
				break;
			case "B0":
				input[2] = "3.0";
				break;
			case "C+":
				input[2] = "2.5";
				break;
			case "C0":
				input[2] = "2.0";
				break;
			case "D+":
				input[2] = "1.5";
				break;
			case "D0":
				input[2] = "1.0";
				break;
			case "F":
				input[2] = "0.0";
				break;
			case "P":
				input[2] = "99";
				break;
			}
			if (Double.parseDouble(input[2])!=99) {
				score = score + Double.parseDouble(input[1])*Double.parseDouble(input[2]);
				grades = grades + Double.parseDouble(input[1]);
			}

		}
		System.out.print(score/grades);
	}
}
