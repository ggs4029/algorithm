// 백준 32205번
// 세모 n개의 각 변의 길이가 주어지면
// 원하는 세모 두 개를 골라 같은 길이의 변이 맞닿게 붙여서
// 네모를 만들 수 있는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 세모 개수 n 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 세모의 변의 길이 a, b, c를 한 줄씩 입력 받음.
// 입력 받은 변의 길이들을 하나로 묶어서 해시셋에 저장하고
// 길이가 같은 변이 들오오나 체크하기.
// 있으면 네모를 항상 만들 수 있으므로 1 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class pr32205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		boolean square = false;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				// 중복 체크
				if(set.contains(tmp))
					square = true;
				set.add(tmp);
			}
		}
		// 출력
		if(square)
			System.out.print(1);
		else
			System.out.print(0);
	}
}