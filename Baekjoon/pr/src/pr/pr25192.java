// 백준 25192번
// 인사성 밝은 곰곰이
// 채팅 기록 중 곰곰티콘이 사용된 횟수를 출력하는 문제
// 방법-------------------------------
// 첫째 줄에 채팅방의 기록 수 N을 입력 받고
// 둘째 줄부터 N개의 줄에 문자열을 입력 받으면서 sum 계산.
// ENTER 는 새로운 사람의 입장을 나타내는 것이므로
// ENTER가 들어오면 해시셋의 사이즈를 sum에 더해준 다음
// 해시셋을 초기화 시켜주고 닉네임이 들어오면 해시셋에 add.
// 로그가 끝날때까지 이를 반복하고 sum값을 출력.
// 중복 검출을 위해 해시셋을 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class pr25192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 + sum 계산
		int n = Integer.parseInt(br.readLine());
		Set log = new HashSet();
		int sum = 0;
		for (int x=0; x<n; x++) {
			String input = br.readLine();
			if(input.equals("ENTER")) {						// 엔터가 들어오면
				sum = sum + log.size();						// 기존에 들어온 닉네임들 더해주고
				log = new HashSet();						// 해시셋 초기화
			}
			else {											// 닉네임이 들어오면
				log.add(input);								// 닉네임 저장
			}
		}
		sum = sum + log.size();								// 마지막으로 들어온 닉네임들 더해주기
		// 출력
		System.out.print(sum);
	}
}