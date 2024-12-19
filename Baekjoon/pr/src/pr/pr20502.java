// 백준 20502번
// 게시글들을 보여줄 순서를 정하기 위해
// 순위 정보를 입력 받고 이 정보들을 바탕으로 q개의 질의에 답해야하는 문제.
// 방법---------------------
// 첫 줄에 n, m이 주어짐.
// 두번째 줄에 순위를 뜻하는 n개의 정수가 주어짐.
// 이후 n개의 줄에 걸쳐 각 게시글이 포함하고 있는 키워드의 수에 대한 정보가 주어짐.
// 그 다음 줄에 질의의 수 q가 주어지고
// 이후 q줄에 걸쳐 각 질의를 나타내는 정수 k를 입력 받음.
// set 사용해 중복 방지하고 질문에 대해 게시글 번호 찾고
// rank 낮은 순으로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pr20502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		String[] input2 = br.readLine().split(" ");
		int[] rank = new int[n];
		for(int i=0; i<n; i++)
			rank[i] = Integer.parseInt(input2[i]);
		List<Set<Integer>> keyword = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String[] input3 = br.readLine().split(" ");
			Set<Integer> tmp = new HashSet<>();
			for(int j=1; j<=Integer.parseInt(input3[0]); j++)
				tmp.add(Integer.parseInt(input3[j]));
			keyword.add(tmp);
		}
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			int k = Integer.parseInt(br.readLine());
			List<Integer> output = new ArrayList<>();
			for(int j=0; j<n; j++) {
				if(keyword.get(j).contains(k))
					output.add(j+1);
			}
			if(!output.isEmpty()) {
				// 정렬
				output.sort(Comparator.comparingInt(a -> rank[a-1]));
				for(int j : output)
					sb.append(j).append(" ");
			}
			else
				sb.append("-1");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}