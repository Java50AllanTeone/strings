package telran;

import java.util.Arrays;
import telran.performance.JoinStringsPerformanceTest;
import telran.text.JoinStringsOnBuilder;
import telran.text.JoinStringsOnStandard;
import telran.text.JoinStringsOnString;

public class JoinStringsPerformanceAppl {
	static final int N_STRINGS = 1000;
	static final int N_RUNS = 10000;
	
	public static void main(String[] args) {
		var arr = getBigArray();
		
		JoinStringsPerformanceTest test1 = new JoinStringsPerformanceTest("testStandard", N_RUNS, arr, new JoinStringsOnStandard());
		JoinStringsPerformanceTest test2 = new JoinStringsPerformanceTest("testBuilder", N_RUNS, arr, new JoinStringsOnBuilder());
		JoinStringsPerformanceTest test3 = new JoinStringsPerformanceTest("testString", N_RUNS, arr, new JoinStringsOnString());
		
		test1.run();
		test2.run();
		test3.run();
	}
	
	private static String[] getBigArray() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "hello");
		return res;
		
	}
}
