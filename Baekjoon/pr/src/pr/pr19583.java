// 백준 19583번
// 스트리밍으로 출석을 확인하는 문제.
// 개강총회를 시작하기 전에, 학회원의 입장 확인 여부를 확인한다.
// 학회원의 입장 여부는 개강총회가 시작한 시간 이전에 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다.
// 개강총회를 시작하자마자 채팅 기록을 남긴 학회원도 제 시간에 입장이 확인된 것으로 간주한다.
// 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까지 학회원의 퇴장 확인 여부를 확인한다.
// 학회원의 퇴장 여부는 개강총회가 끝나고 스트리밍이 끝날 때까지 대화를 한 적이 있는 학회원의 닉네임을 보고 체크한다.
// 개강총회가 끝나자마자 채팅 기록을 남겼거나,
// 개강총회 스트리밍이 끝나자마자 채팅 기록을 남긴 학회원도 제 시간에 퇴장이 확인된 것으로 간주한다.
// 방법---------------------
// 첫 줄에 개강총회 시작 시간 s, 개강총회 개강총회 끝난 시간 e, 개강총회 스트리밍 끝낸 시간 q가 주어짐.
// 다음 줄부터 스트리밍 영상의 채팅 기록들이 시간순으로 주어진다.
// 해시셋 두개 구현해 하나는 입장을 했는지 하나는 스트리밍중 대화를 했는지 체크.
// 시간은 모두 분으로 바꿔 계산.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class pr19583 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] time = st.nextToken().split(":");
		int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		time = st.nextToken().split(":");
		int end = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		time = st.nextToken().split(":");
		int stream = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		Set<String> in = new HashSet<>();
		Set<String> out = new HashSet<>();
		String input;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			String[] input2 = input.split(" ");
			String[] time2 = input2[0].split(":");
			int tmp = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
            String student = input2[1];
			if(0<=tmp && tmp<=start)				// 출석여부 확인
				in.add(student);
			if (end<=tmp && tmp<=stream)			// 퇴장여부 확인
				out.add(student);
		}
		// 출력
		Set<String> output = new HashSet<>(in);
		output.retainAll(out);						// 겹치는 부분만
		System.out.print(output.size());
	}
}