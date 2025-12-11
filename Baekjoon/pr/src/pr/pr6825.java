import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6825 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		double w = Double.parseDouble(br.readLine());
		double h = Double.parseDouble(br.readLine());
		// bmi 구하고 출력
		double bmi = w / (h * h);
		if(bmi > 25)
			System.out.print("Overweight");
		else if(18.5<=bmi && bmi<=25)
			System.out.print("Normal weight");
		else
			System.out.print("Underweight");
	}
}