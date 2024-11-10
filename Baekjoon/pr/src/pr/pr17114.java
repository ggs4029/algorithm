// 백준 17114번
// 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어지면
// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 문제.
// 백준 7576번이 1차원이고
// 백준 7569번이 2차원이면 이 문제는 11차원.
// 방법---------------------
// 첫줄에 크기를 나타내는 세 정수 m, n, o, p, q, r, s, t, u, v, w가 주어짐.
// 둘째 줄부터는 상자에 저장된 토마토들의 정보들이 좌르륵 주어짐.
// 익은 토마토를 큐에 추가해가고 익지 않은 토마토는 tmp에 +1.
// bfs를 돌며 인접한 여섯방향의 토마토들을 탐색해감.
// 익지 않은 토마토가 남아있는지 확인하고 -1, 0 이나 양의 정수를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr17114 {

	public static int M, N, O, P, Q, R, S, T, U, V, W = 0;
	public static int[][][][][][][][][][][] list;
	public static Queue<int[]> que = new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] dy = {0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] dz = {0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] da = {0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] db = {0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] dc = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] dd = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
	public static int[] de = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0};
	public static int[] df = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0};
	public static int[] dg = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0};
	public static int[] dh = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1};
	public static int tmp = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int[] aa = new int[11];
		for(int i=0; i<11; i++)
			aa[i] = Integer.parseInt(input[i]);
		M = aa[0];
        N = aa[1];
        O = aa[2];
        P = aa[3];
        Q = aa[4];
        R = aa[5];
        S = aa[6];
        T = aa[7];
        U = aa[8];
        V = aa[9];
        W = aa[10];
        list = new int[W][V][U][T][S][R][Q][P][O][N][M];
		//list = new int[aa[10]][aa[9]][aa[8]][aa[7]][aa[6]][aa[5]][aa[4]][aa[3]][aa[2]][aa[1]][aa[0]];
		for(int w=0; w<W; w++) {
			for(int v=0; v<V; v++) {
				for(int u=0; u<U; u++) {
					for(int t=0; t<T; t++) {
						for(int s=0; s<S; s++) {
							for(int r=0; r<R; r++) {
								for(int q=0; q<Q; q++) {
									for(int p=0; p<P; p++) {
										for(int o=0; o<O; o++) {
											for(int n=0; n<N; n++) {
												String[] input2 = br.readLine().split(" ");
												for(int m=0; m<M; m++) {
													list[w][v][u][t][s][r][q][p][o][n][m] = Integer.parseInt(input2[m]);
                                                    if (list[w][v][u][t][s][r][q][p][o][n][m] == 1) {
                                                        que.add(new int[]{w, v, u, t, s, r, q, p, o, n, m, 0});
                                                    } else if (list[w][v][u][t][s][r][q][p][o][n][m] == 0) {
                                                        tmp++;
                                                    }
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// bfs + 출력
		System.out.print(bfs());
	}

	// bfs
	public static int bfs() {
		int output = 0;
		while(!que.isEmpty()) {
			int[] tmp2 = que.poll();
			int day = tmp2[11];
			int[] tmp3 = new int[12];
			for(int i=0; i<12; i++)
				tmp3[i] = tmp2[i];
			for(int j=0; j<22; j++) {
				int[] tmp4 = new int[12];
				for(int i=0; i<12; i++)
					tmp4[i] = tmp3[i];
				tmp4[0] += dx[j];
				tmp4[1] += dy[j];
				tmp4[2] += dz[j];
				tmp4[3] += da[j];
				tmp4[4] += db[j];
				tmp4[5] += dc[j];
				tmp4[6] += dd[j];
				tmp4[7] += de[j];
				tmp4[8] += df[j];
				tmp4[9] += dg[j];
				tmp4[10] += dh[j];
				if(tmp4[0]>=0 && tmp4[1]>=0 && tmp4[2]>=0 &&
						tmp4[3]>=0 && tmp4[4]>=0 && tmp4[5]>=0 &&
								tmp4[6]>=0 && tmp4[7]>=0 && tmp4[8]>=0 &&
										tmp4[9]>=0 && tmp4[10]>=0 &&
					tmp4[0]<W && tmp4[1]<V && tmp4[2]<U &&
						tmp4[3]<T && tmp4[4]<S && tmp4[5]<R &&
							tmp4[6]<Q && tmp4[7]<P && tmp4[8]<O &&
								tmp4[9]<N && tmp4[10]<M &&
					list[tmp4[0]][tmp4[1]][tmp4[2]][tmp4[3]][tmp4[4]][tmp4[5]]
							[tmp4[6]][tmp4[7]][tmp4[8]][tmp4[9]][tmp4[10]] == 0) {
					list[tmp4[0]][tmp4[1]][tmp4[2]][tmp4[3]][tmp4[4]][tmp4[5]]
							[tmp4[6]][tmp4[7]][tmp4[8]][tmp4[9]][tmp4[10]] = 1;
					tmp--;
					que.offer(new int[]{tmp4[0], tmp4[1], tmp4[2], tmp4[3], tmp4[4], tmp4[5], tmp4[6], tmp4[7], tmp4[8], tmp4[9], tmp4[10], day + 1});
					output = day+1;
				}
			}
		}
		if(tmp>0)
			return -1;
		else
			return output;
	}
}