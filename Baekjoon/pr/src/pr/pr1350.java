// 백준 1350번
// 파일의 사이즈와 클러스터의 크기가 주어질 때,
// 사용한 디스크 공간을 출력하는 문제.
// 방법---------------------
// 첫 줄에 파일의 개수 n을 입력 받음.
// 둘째 줄에 파일의 크기들이 공백을 사이에 두고 주어진다.
// 다음 줄에는 클러스터의 크기가 주어짐.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1350 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] file = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			file[i] += Long.parseLong(st.nextToken());
		long cluster = Long.parseLong(br.readLine());
		// 디스크 공간 계산
		long sum = 0;
		for(int i=0; i<n; i++) {
			if(file[i]>cluster) {
				if(file[i]%cluster==0)
					sum += file[i]/cluster * cluster;
				else
					sum += file[i]/cluster * cluster + cluster;
			}
			else if(file[i]==0)
				continue;
			else
				sum += cluster;
		}
		// 출력
		System.out.print(sum);
	}
}