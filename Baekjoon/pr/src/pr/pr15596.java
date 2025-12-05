public class pr15596 {
	long sum(int[] a) {
		long output = 0;
		for(int i=0; i<a.length; i++)
			output += a[i];
		return output;
	}
}