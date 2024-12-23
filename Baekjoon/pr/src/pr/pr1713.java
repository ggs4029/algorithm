// 백준 1713번
// 월드초등학교 학생회장 후보는 일정 기간 동안 전체 학생의 추천에 의하여 정해진 수만큼 선정된다.
// 그래서 학교 홈페이지에 추천받은 학생의 사진을 게시할 수 있는 사진틀을 후보의 수만큼 만들었다.
// 후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정하는 프로그램을 작성.
// 추천 받은 횟수를 표시하는 방법은 문제에 나와있음.
// 방법---------------------
// 첫 줄에 사진틀 개수 n이 주어짐.
// 둘째 줄에는 전체 학생의 총 추천 횟수가 주어지고,
// 셋째 줄에는 추천받은 학생을 나타내는 번호가 빈 칸을 사이에 두고 추천받은 순서대로 주어짐.
//리스트 두개와 해시맵을 이용해 추천 수와 추천이 들어온 순서를 관리해서 결과를 출력한다.

// 오답노트
// 지울애 지울때
// board.remove(Integer.valueOf(tmp2));
// vote.remove(Integer.valueOf(tmp2));
// 이거 Integer.valueOf()로 int형을 Integer로 변환해서 넣어야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pr1713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		// 사진틀에 사진 올리기
		List<Integer> board = new ArrayList<>();
		Map<Integer, Integer> m = new HashMap<>();
		List<Integer> vote = new ArrayList<>();					// 추천 들어온 순서 저장할 배열리스트
		for(int i=0; i<num;  i++) {
			int tmp = Integer.parseInt(input[i]);
			if(board.contains(tmp))								// 이미 게시중이면
				m.put(tmp, m.get(tmp)+1);						// 추천 수 +1
			else {												// 게시중이 아닌 사진이고
				if(board.size()<n) {							// 보드가 비어있으면
					board.add(tmp);								// 게시
                    m.put(tmp, 1);
                    vote.add(tmp);
				}
				else {											// 보드가 꽉차있으면
					int min = 1557;								// 제일 적은 추천 수를 찾기 위한 변수
					int tmp2 = 1557;							// 제일 적은 추천 수를 가진 후보의 인덱스 저장용
					for(int j=0; j<n;  j++) {
						int cS = board.get(j);
                        int cV = m.get(board.get(j));
						if(cV<min) {
							min = cV;
							tmp2 = cS;
						}
						else if(cV==min) {						// 추천 횟수 동일하면 오래된거 삭제
							if (vote.indexOf(cS)<vote.indexOf(tmp2))
								tmp2 = cS;
						}
					}
					m.put(tmp2, 0);								// 지울 애 지우기
					board.remove(Integer.valueOf(tmp2));
					vote.remove(Integer.valueOf(tmp2));
					board.add(tmp);								// 넣을 애 넣기
                    m.put(tmp, 1);
                    vote.add(tmp);
				}
			}
		}
		// 출력
		Collections.sort(board);
		for(int i : board)
			sb.append(i).append(" ");
		System.out.print(sb.toString());
	}
}