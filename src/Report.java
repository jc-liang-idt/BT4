
public class Report {

	/* ??? what do these letters stand for??? */
	private String[] getTextResults;
	private String[] getPics;
	private int e; /*
					 * e or r is the number of screenshots or the number of
					 * lines in the report, but we aren't sure because Jan
					 * Miranda did a terrible job with his documentation
					 */
	private int r;

	public Report() {

	}

	public Report(String[] a, String[] b, int c, int d) {
		getTextResults = a;
		getPics = b;
		e = c;
		r = d;
	}

	public String[] getResults() {
		return getTextResults;
	}

	public String[] getPics() {
		return getPics;
	}

	public int getCount() {
		return e;
	}

	public int getR() {
		return r;
	}
}
