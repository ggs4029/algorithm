import java.time.ZoneId;
import java.time.ZonedDateTime;

public class pr16170 {
	public static void main (String[] args) {
    	ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(zonedDateTime.getYear());
        System.out.println(zonedDateTime.getMonthValue());
        System.out.print(zonedDateTime.getDayOfMonth());
    }
}