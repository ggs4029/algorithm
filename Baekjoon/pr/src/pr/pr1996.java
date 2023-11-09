// 백준 1996번
// 지뢰 찾기
// 방법---------------
// n을 입력 받고
// 그다음 n줄에 걸쳐 지뢰찾기 map에 대한 정보를 2차원배열 mine에 입력 받는다.
// 2차원 배열로 만들었기 때문에 지뢰는 -1로 표현해 저장한다.
// 입력 받은 값이 숫자면 그 위치에는 지뢰를 뜻하는 -1을 저장하고
// 그 주위의 8구역에는 그 숫자를 더해준다.
// n이 1일 경우를 주의해서 if문을 통해 잘 더해주고
// 최종 map을 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pr1996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] mine = new int[n][n];
		for(int x=0; x<n; x++)
			for(int y=0; y<n; y++)
				mine[x][y] = 0;
		for(int x=0; x<n; x++) {
			String[] input = br.readLine().split("");
			for(int y=0; y<n; y++) {
				if(!input[y].equals(".") && n!=1) { // 숫자면 그 위치에는 -100을 저장하고 주변8구역에는 입력받은 숫자를 더함.
					mine[x][y] = -100;
					if(x==0 && y==0) { // 맨위왼쪽구석
						mine[x][y+1] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
						mine[x+1][y+1] += Integer.parseInt(input[y]);
					}
					else if(x==0 && y==n-1) { // 맨위오른쪽구석
						mine[x][y-1] += Integer.parseInt(input[y]);
						mine[x+1][y-1] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
					}
					else if(x==n-1 && y==0) { // 맨아래왼쪽구석
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x-1][y+1] += Integer.parseInt(input[y]);
						mine[x][y+1] += Integer.parseInt(input[y]);
					}
					else if(x==n-1 && y==n-1) { // 맨아래오른쪽구석
						mine[x-1][y-1] += Integer.parseInt(input[y]);
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x][y-1] += Integer.parseInt(input[y]);
					}
					else if(x==0) { // 구석이 아니고 x가 0인 경우
						// 양 옆 두개
						mine[x][y-1] += Integer.parseInt(input[y]);
						mine[x][y+1] += Integer.parseInt(input[y]);
						// 아래 세개
						mine[x+1][y-1] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
						mine[x+1][y+1] += Integer.parseInt(input[y]);
					}
					else if(x==n-1) { // 구석이 아니고 x가 맨 아래줄인 경우
						// 양 옆 두개
						mine[x][y-1] += Integer.parseInt(input[y]);
						mine[x][y+1] += Integer.parseInt(input[y]);
						// 위에 세개
						mine[x-1][y-1] += Integer.parseInt(input[y]);
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x-1][y+1] += Integer.parseInt(input[y]);
					}
					else if(y==0) { // 구석이 아니고 y가 0인 경우
						// 위 아래 하나씩 두개
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
						// 오른쪽 세개
						mine[x-1][y+1] += Integer.parseInt(input[y]);
						mine[x][y+1] += Integer.parseInt(input[y]);
						mine[x+1][y+1] += Integer.parseInt(input[y]);
					}
					else if(y==n-1) { // 구석이 아니고 y가 오른쪽 끝인 경우
						// 위 아래 하나씩 두개
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
						// 왼쪽 세개
						mine[x-1][y-1] += Integer.parseInt(input[y]);
						mine[x][y-1] += Integer.parseInt(input[y]);
						mine[x+1][y-1] += Integer.parseInt(input[y]);
					}
					else { // 나머지 중간에 있는 것들
						// 위에 세개
						mine[x-1][y-1] += Integer.parseInt(input[y]);
						mine[x-1][y] += Integer.parseInt(input[y]);
						mine[x-1][y+1] += Integer.parseInt(input[y]);
						// 같은 줄에 두개
						mine[x][y-1] += Integer.parseInt(input[y]);
						mine[x][y+1] += Integer.parseInt(input[y]);
						// 아래 세개
						mine[x+1][y-1] += Integer.parseInt(input[y]);
						mine[x+1][y] += Integer.parseInt(input[y]);
						mine[x+1][y+1] += Integer.parseInt(input[y]);
					}
				}
				else if(!input[y].equals(".") && n==1) { // 지뢰인데 n이 1인 경우
					mine[x][y] = -100;
				}
			}
		}
		// 출력
		for(int x=0; x<mine.length; x++) {
			for(int y=0; y<mine.length; y++) {
				if(mine[x][y]<0) {
					bw.write("*");
				}
				else if(mine[x][y]>=10) {
					bw.write("M");
				}
				else {
					bw.write(mine[x][y]+"");
				}
			}
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
}
