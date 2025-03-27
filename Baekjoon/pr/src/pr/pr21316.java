// 백준 21316번
// 처녀자리 중 12개의 별을 12개의 선분으로 이어 만든 그림이 주어짐.
// 임의로 각 별에 1~12까지 번호를 부여하고 12개의 정수 쌍으로 각 선분이 어떤 별들을 잇는지 기록했음.
// 이후에 어떤 별에 어떤 번호를 부여했는지 잊어버렸을때
// 선분들의 정보가 주어지면 가장 밝은 별인 spica가 몇 번 별인지 구하는 문제.
// 방법---------------------
// 12줄의 입력이 들어옴.
// 각 줄은 x, y 두개의 정수고 두 별 x와 y를 잇는 선분이 있다는 뜻.
// 스피카는 주변에 세 별이랑 이어져있고
// 그 세별은 각각 주변에 3개, 1개, 2개의 별들하고 이어져있음.
// 입력 받은 정보들 저장하고 별들 순회하면서 위의 특징 두개랑 맞는지 확인 후 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pr21316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		ArrayList<Integer>[] star = new ArrayList[12];
		for(int i=0; i<12; i++)
			star[i] = new ArrayList<>();
        int[] countingStar = new int[12];
		for(int i=0; i<12; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			countingStar[x-1]++;										// x
			countingStar[y-1]++;										// y
			star[x-1].add(y-1);
			star[y-1].add(x-1);
		}
		// 스피카 특정하기
		int spica = 1557;
		for(int i=0; i<12; i++) {
			if(countingStar[i] != 3)									// 이어져있는 별이 3개가 아니면
				continue;
			int tmp = 0;
			for(int j : star[i])
				tmp += countingStar[j];
			if(tmp == 6) {											// 스피카 주변 별 3개랑 이어져있는 별들의 합이 6이면
				spica = i+1;
				break;
			}
		}
		// 출력
		System.out.print(spica);
	}
}