// 백준 1157번
// 알파벳이 대소문자로 주어지면
// 가장 많이 쓰인 알파벳을 대문자로 출력하는 문제
// 방법-------------------------------
// 단어를 입력받고
// 입력받은 단어를 전부 대문자로 바꿈
// A~Z까지 횟수를 셀 배열을 만든 후
// 개수를 센다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 후 전부 대문자로 바꿈
		String input = br.readLine().toUpperCase();
		// 배열들 생성
		char[] input2 = input.toCharArray();
		int[] sum = new int[26];
		// 개수 새기
		for (char c : input2) {
			sum[c - 65]++; // ascii code 대문자 A = 65부터 시작
		}
		// 가장 많이 사용된 알파벳 찾기
		int max = 0;
		int index = 0;
		for (int x = 0; x < sum.length; x++) {
			if (sum[x] > max) {
				max = sum[x];
				index = x;
			}
		}
		char ch = (char) (index+65);
		// 최종 출력
		Arrays.sort(sum);
		if (input2.length == 1) { // 단어의 길이가 1인 경우
			System.out.print(input2[0]);
		} else { // 단어의 길이가 1이 아닌 경우
			if (sum[sum.length - 1] != sum[sum.length - 2]) {
				System.out.println(ch);
			} else { // 가장 많이 사용된 알파벳이 여러개인 경우
				System.out.println("?");
			}
		}
	}
}
