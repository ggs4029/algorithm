// 백준 1475번
// 방 번호를 플라스틱 세트로 만드는데 필요한 세트의 개수
// 6과9는 뒤집이서 이용이 가능하다.
// 방법---------------
// 방번호를 입력 받고 0~9까지 저장할 배열을 만든다.
// 9일때는 6에 몰아 저장하고 다른 번호들은 그냥 그대로 자기 자리에 저장한다.
// 세트 개수를 세고 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split("");
		// 배열에 저장
		int[] room = new int[10]; // 0~9 배열
		for(int x=0; x<input.length; x++) {
			if(Integer.parseInt(input[x])==9) { // 9면
				++room[6];
			}
			else { // 9가 아닌 아닌 다른 수면
				++room[Integer.parseInt(input[x])];
			}
		}
		// 세트 개수 세기
		room[6] = room[6]/2 + room[6]%2;
		Arrays.sort(room);
		// 출력
		System.out.print(room[room.length-1]);
	}
}