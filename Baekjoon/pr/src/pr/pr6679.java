import java.io.IOException;

public class pr6679 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=1000; i<=9999; i++) {
			int decimal = 0;
			int decimal12 = 0;
			int hex = 0;
			// 자릿수 더하기
			for(int j=i; j>0; j/=10)
				decimal += j%10;
			for(int j=i; j>0; j/=12)
				decimal12 += j%12;
			for(int j=i; j>0; j/=16)
				hex += j%16;
			// 싱기한 숫자 구하기
			if(decimal==decimal12 && decimal12==hex)
				sb.append(i).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}