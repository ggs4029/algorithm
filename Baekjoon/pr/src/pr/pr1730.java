// 백준 1730번
// 판화
// 방법--------------
// 목판의 크기 n을 입력 받고
// 움직임을 입력 받는다.
// 목판을 2차원 배열로 만들어 for문과 switch문을 활용해
// 로봇팔이 움직일때마다 해당하는 배열의 원소의 값을 바꾼다.
// 로봇팔이 목판 밖을 나가는 경우의 움직임에 대해서도
// 그 움직임을 무시하고 다음 움직임을 처리하도록한다. (Out of Index)
// 최종결과로 2차원 배열을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1730 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		// 2차원 배열 생성과 초기화
		String[][] output = new String[n][n];
		for (int x = 0; x < n; x++)
			for (int y = 0; y < n; y++)
				output[x][y] = ".";
		// 연산
		int x = 0;
		int y = 0;
		for (int i = 0; i < input.length(); i++) {
			char draw = input.charAt(i);
			switch(draw) {
			case 'L':
				if(y!=0) {
					if(output[x][y] == ".") {
						output[x][y] = "-";
					}
					else if(output[x][y] == "|") {
						output[x][y] = "+";
					}
					y--;
					if(output[x][y] == ".") {
                        output[x][y] = "-";
                    }
					else if(output[x][y] == "|") {
                        output[x][y] = "+";
                    }
				}
				break;
			case 'R':
				if(y!=n-1) {
					if(output[x][y] == ".") {
						output[x][y] = "-";
					}
					else if(output[x][y] == "|") {
						output[x][y] = "+";
					}
					y++;
					if(output[x][y] == ".") {
                        output[x][y] = "-";
                    }
					else if(output[x][y] == "|") {
                        output[x][y] = "+";
                    }
				}
				break;
			case 'U':
				if(x!=0) {
					if(output[x][y] == ".") {
						output[x][y] = "|";
					}
					else if(output[x][y] == "-") {
						output[x][y] = "+";
					}
					x--;
					if(output[x][y] == ".") {
                        output[x][y] = "|";
                    }
					else if(output[x][y] == "-") {
                        output[x][y] = "+";
                    }
				}
				break;
			case 'D':
				if(x!=n-1) {
					if(output[x][y] == ".") {
						output[x][y] = "|";
					}
					else if(output[x][y] == "-") {
						output[x][y] = "+";
					}
					x++;
					if(output[x][y] == ".") {
                        output[x][y] = "|";
                    }
					else if(output[x][y] == "-") {
                        output[x][y] = "+";
                    }
				}
				break;
			}
		}
		// 최종 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}

	}
}