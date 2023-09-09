// 백준 1427번
// 수가 주어지면
// 그 수의 각 자리수를 내림차순으로 정렬 하는 문제
// 방법---------------------------------
// 수를 String 배열로 입력 받아 각 자리마다 자름
// 입력 받은 String 배열을 int 배열로 바꿔준 후
// 오름차순으로 정렬한 뒤
// 맨 뒤 인덱스부터 출력한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split("");
		int[] input2 = new int[input.length];
		for(int x=0; x<input.length; x++) {
			input2[x] = Integer.parseInt(input[x]);
		}
		Arrays.sort(input2); // 정렬
		// 최종 출력
		for(int x=input2.length-1; x>=0; x--) {
			System.out.print(input2[x]);
		}
	}
}
