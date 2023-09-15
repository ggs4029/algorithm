// 백준 1009번
// 분산처리
// 10대의 컴퓨터가 데이터를 하나씩 분산처리 할때
// a^b개의 데이터가 주어지면
// 마지막 데이터는 몇번 컴퓨터가 처리하는지 구하는 문제
// 방법-----------------
// 첫째 줄에 테스트 케이스의 개수를 입력 받고
// 그 다음부터 테스트 케이스의 값만큼의 줄을 사용해 a와 b를 입력 받는다
// a^b를 구한 뒤 10으로 나눈 나머지를 출력한다.
// a^b가 너무 커지는 경우 다른 답이 나오기 때문에 매 계산 결과의 1의 자리만 곱해 계산한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int x=0; x<t; x++) {
			// 입력
			int output = 1;
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			// 매 계산의 1의 자리에만 a를 곱해감
			for(int y=1; y<=b; y++) {
				output = output*a%10;
			}
			if(output==0) // 1의 자리가 0이어서 output이 0이 나온 경우
				output = 10; // 10번 컴퓨터가 처리
			// 최종 출력
			System.out.println(output);
		}
	}
}