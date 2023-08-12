// 백준 11718번
// 입력 받은 그대로 출력하기
// 입력은 최대 100줄
// 각 줄은 100글자 이하 , 빈줄 x
// 각 줄은 공백 시작x, 끝x

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11718 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=br.readLine()) != null) {
			System.out.println(input);
		}
	}
}