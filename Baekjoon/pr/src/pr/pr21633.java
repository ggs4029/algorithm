import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21633 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        double k = Double.parseDouble(br.readLine());
        // 상, 하한선 체크
        double commission = 25 + (k * 0.01);
        if(commission < 100)
            commission = 100;
        if(commission > 2000)
            commission = 2000;
        // 출력
        System.out.print(String.format("%.2f", commission));
    }
}