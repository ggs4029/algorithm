// 백준 2025IUPC_B번
// 신묘마루가 운영자가 준비한 햄버거를 8개의 그릇 중 하나에 숨기고 섞어버림.
// 8개의 밥그릇은 처음에 4행 2열 형태로 배치되어 있으며
// 신묘마루가 섞을 때 쓴 기술이 A ~ D까지 4가지임.
// 신묘마루가 어떤 기술을 썼는지 주어지면 햄버거가 있는 밥그릇을 찾는 문제.
// 방법---------------------
// 첫 줄에 햄버거를 처음 숨긴 밥그릇의 위치 n, m이 주어짐.
// 다음 줄에 기술 사용횟수 k가 주어지고
// 그 다음 줄에 어떤 기술을 사용했는지 문자열로 주어짐.
// 입력 받은 기술에 따라 if문으로 햄버거가 들어있는 위치 바꿔가며
// 최종위치를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		String skill = br.readLine();
		// 햄버거를 찾아서
		for(int i=0; i<skill.length(); i++) {
			char tmp = skill.charAt(i);				// 이번 기술
			if(tmp == 'A') {						// 기술 A - 2행씩 위아래 교환
				if(n>=3)
					n -= 2;
				else
					n += 2;
			}
			else if(tmp == 'B') {					// 기술 B - 2행씩 묶은 그룹 안에서 x자 교환
				if(n <= 2) {						// 윗 그룹
					if(n==1 && m==1) {
						n = 2;
						m = 2;
					}
					else if(n==1 && m==2) {
						n = 2;
						m = 1;
					}
					else if(n==2 && m==1) {
						n = 1;
						m = 2;
					}
					else {
						n = 1;
						m = 1;
					}
				}
				else {								// 아래 그룹
					if(n==3 && m==1) {
						n = 4;
						m = 2;
					}
					else if(n==3 && m==2) {
						n = 4;
						m = 1;
					}
					else if(n==4 && m==1) {
						n = 3;
						m = 2;
					}
					else {
						n = 3;
						m = 1;
					}
				}
			}
			else if(tmp == 'C') {					// 기술 C - 가운데 2행을 묶은 그룹 안에서 x자 교환 + 남은 행들끼리 x자 교환
				if(n==2 || n==3) {					// 가운데 그룹
					if(n==2 && m==1) {
						n = 3;
						m = 2;
					}
					else if(n==2 && m==2) {
						n = 3;
						m = 1;
					}
					else if(n==3 && m==1) {
						n = 2;
						m = 2;
					}
					else {
						n = 2;
						m = 1;
					}
				}
				else {								// 나머지 그룹
					if(n==1 && m==1) {
						n = 4;
						m = 2;
					}
					else if(n==1 && m==2) {
						n = 4;
						m = 1;
					}
					else if(n==4 && m==1) {
						n = 1;
						m = 2;
					}
					else {
						n = 1;
						m = 1;
					}
				}
			}
			else {								// 기술 D - 모든 밥그릇이 시계방향으로 한바퀴 회줜
				if(n==1 && m==1) {
					n = 1;
					m = 2;
				}
				else if(n==1 && m==2) {
					n = 2;
					m = 2;
				}
				else if(n==2 && m==2) {
					n = 3;
					m = 2;
				}
				else if(n==3 && m==2) {
					n= 4;
					m = 2;
				}
				else if(n==4 && m==2) {
					n = 4;
					m = 1;
				}
				else if(n==4 && m==1) {
					n = 3;
					m = 1;
				}
				else if(n==3 && m==1) {
					n = 2;
					m = 1;
				}
				else {
					n = 1;
					m = 1;
				}
			}
		}
		// 출력
		System.out.print(n + " " + m);
	}
}