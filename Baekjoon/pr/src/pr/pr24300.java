// 백준 24300번
// 주어진 n개의 양의 정수가 있는 배열 aN에서
// 모든 i와 j에 대해 ai를 aj로 나눈 나머지의 최대값을 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 다음줄에 n개의 양의 정수를 입력 받음
// 트리셋 사용해 저장. (자동정렬)
// a<b이면 a%b=a 이므로 (두번째로 큰값) % (제일 큰 값) 하면 최대값.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeSet;

public class pr24300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		TreeSet<BigInteger> num = new TreeSet<>();
		for(int i=0; i<n; i++)
			num.add(new BigInteger(input[i]));
		// 최대값 구하기
		BigInteger a = num.last();
		BigInteger b = num.lower(a);				// num.last보다 작은 원소들 중 최댓값
		// 출력
		System.out.print(b);
	}
}