// 백준 3003번
// 체스말의 개수를 구하는 문제
// 흰색피스의 개수가 맞지 않음
// 발견한 피스의 개수가 주어지면
// 몇개를 더하거나 빼야 올바른 세트가되는지 구하는 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr3003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 변수
		int[] arr = new int[6];
		arr[0] = 1; arr[1] = 1; arr[2] = 2;
		arr[3] = 2; arr[4] = 2; arr[5] = 8;
		// 입력 받기
		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
		arr[0] = arr[0] - Integer.parseInt(input.nextToken());
		arr[1] = arr[1] - Integer.parseInt(input.nextToken());
		arr[2] = arr[2] - Integer.parseInt(input.nextToken());
		arr[3] = arr[3] - Integer.parseInt(input.nextToken());
		arr[4] = arr[4] - Integer.parseInt(input.nextToken());
		arr[5] = arr[5] - Integer.parseInt(input.nextToken());
		// 최종출력
		System.out.print(arr[0] + " ");
		System.out.print(arr[1] + " ");
		System.out.print(arr[2] + " ");
		System.out.print(arr[3] + " ");
		System.out.print(arr[4] + " ");
		System.out.print(arr[5] + " ");

	}
}
