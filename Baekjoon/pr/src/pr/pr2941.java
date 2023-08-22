// 백준 2941번
// 크로아티아 알파벳으로 이루어진 단어가 주어지면
// 그것이 몇개의 크로아티아 알파벳으로 되어있는지 출력하는 문제
// 방법--------------------------------
// 일반 알파벳과 다른 크로아티아 알파벳들만
// if문을 통해 검출한 후
// 총 몇개의 알파벳으로 되어있는지 센다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		// 알파벳 개수 찾기
		int sum = 0;
		for(int x=0; x<input.length; x++) {
			char c1 = input[x].charAt(0); // 형 변환
			if(c1=='c' && x<input.length-1) { // c로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='=' || c2=='-') { // = or - 이면
					++x;
				}
			}
			else if(c1=='d' && x<input.length-1) { // d로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='-') { // - 이면
					++x;
				}
				else if (c2=='z' && x<input.length-2) { // dz로 시작하면
					char c3 = input[x+2].charAt(0);
					if(c3=='=') { // = 이면
						++x;
						++x; // +2
					}
				}
			}
			else if(c1=='l' && x<input.length-1) { // l로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='j') { // j 이면
					++x;
				}
			}
			else if(c1=='n' && x<input.length-1) { // n으로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='j') { // j 이면
					++x;
				}
			}
			else if(c1=='s' && x<input.length-1) { // s로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='=') { // j 이면
					++x;
				}
			}
			else if(c1=='z' && x<input.length-1) { // z로 시작하면
				char c2 = input[x+1].charAt(0);
				if(c2=='=') { // j 이면
					++x;
				}
			}
			++sum;
		}
		// 최종출력
		System.out.print(sum);
	}

}
