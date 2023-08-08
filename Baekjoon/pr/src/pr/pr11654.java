// 백준 11654번
// 알파벳, 숫자0~9를 입력받고
// 그것의 아스키코드 값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.print(input.hashCode());
	}

}
