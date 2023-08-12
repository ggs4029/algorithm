// 백준 5622번
// 다이얼을 걸기 위한 시간 계산 문제
// 숫자 1을 거는데 2초, 그보다 큰수를 거는데에는 1증가할때마다 +1초씩
// 방법-----------------------------
// 알파벳 대문자를 입력받고
// for문을 돌며 문자 하나하나당 걸리는 시간을
// switch문으로 계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 단어 입력 받기
		String[] word = br.readLine().split("");
		int sum = 0;
		for(int x=0; x<word.length; x++) {
			switch(word[x]) { // 조건
			case "A":
			case "B":
			case "C":
				sum+=3;
				break;
			case "D":
			case "E":
			case "F":
				sum+=4;
				break;
			case "G":
			case "H":
			case "I":
				sum+=5;
				break;
			case "J":
			case "K":
			case "L":
				sum+=6;
				break;
			case "M":
			case "N":
			case "O":
				sum+=7;
				break;
			case "P":
			case "Q":
			case "R":
			case "S":
				sum+=8;
				break;
			case "T":
			case "U":
			case "V":
				sum+=9;
				break;
			case "W":
			case "X":
			case "Y":
			case "Z":
				sum+=10;
				break;
			}
		}
		System.out.print(sum);
	}
}