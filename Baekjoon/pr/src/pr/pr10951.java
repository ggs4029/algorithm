// 백준 10951번
// 두개를 입력을 받고 a+b를 출력한다


package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10951 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test;
		while((test = br.readLine()) != null) {
			String[] test1 = test.split(" ");
			int a = Integer.parseInt(test1[0]);
			int b = Integer.parseInt(test1[1]);
			System.out.println(a+b);
		}
	}
}