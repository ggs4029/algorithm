// 백준 10798번
// 행렬을 세로로 읽어 한줄로 출력하는 문제
// 방법--------------------------
// 단어 5개를 한줄씩 입력받고
// 제일 긴 단어의 길이가 N이면 N * N 행렬을 만들고
// 한글자씩 집어넣는다.
// 단어의 길이가 N보다 짧아 행렬에 넣을 수 없다면 해당 위치에 ""을 넣는다.
// 이 행렬을 세로로 한줄로 이어 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력을 저장할 행렬 생성
		String[][] arr = new String[5][15];
		// 행렬 입력 받기
		for (int x = 0; x < 5; x++) {
			String input[] = br.readLine().split("");
			for (int y = 0; y < input.length; y++) {
				arr[x][y] = input[y];
			}
			for (int y = input.length; y < 15; y++) { // 나머지를 ""로
				arr[x][y] = "";
			}
		}
		// 최종 출력
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.print(arr[y][x]);
			}
		}
	}
}