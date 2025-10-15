// 백준 14670번
// 영정이는 병약해서 상비약들을 들고다님.
// 각 약들은 이름과 필요한 증상이 적혀져 있고 하나의 약은 하나의 증상만을 해결 가능함.
// 각각의 약은 모두 다른 이름을 가지고 있으며 서로 다른 증상을 해결함이 보장된다.
// 아픈 증상을 호소 할 때, 어떤 약들을 먹어야 하는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 약 종류의 개수 n이 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 약의 효능이랑 약의 이름이 한 줄에 주어짐.
// 그 다음 줄에 영정이가 겪는 증상의 개수 r이 입력으로 주어지고
// 그 다음 줄부터 r줄에 걸쳐 증상의 개수 li랑 증상들 si들이 주어짐.
// 중복 없으므로 해시맵 사용.
// 증상들과 약의 효능을 체크하면서 약의 번호를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class pr14670 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> medicine = new HashMap<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken());							// 효능
			int mn = Integer.parseInt(st.nextToken());							// 이름
			medicine.put(me, mn);
		}
		int r = Integer.parseInt(br.readLine());
		for(int i=0; i<r; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int li = Integer.parseInt(st.nextToken());							// 증상 개수
			List<Integer> sick = new ArrayList<>();
			boolean tmp = true;
			for(int j=0; j<li; j++) {
				int si = Integer.parseInt(st.nextToken());
				if(medicine.containsKey(si))									// 증상에 맞는 약 있으면
					sick.add(medicine.get(si));
				else {															// 맞는 약 없으면
					tmp = false;
					break;
				}
			}
			if(tmp) {
				for(int j=0; j<sick.size(); j++)
					sb.append(sick.get(j)).append(" ");
				sb.append("\n");
			}
			else																// 해결 불가능하면
				sb.append("YOU DIED").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}