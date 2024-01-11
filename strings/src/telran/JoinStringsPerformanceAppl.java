package telran;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.ServiceLoader;

import telran.performance.JoinStringsPerformanceTest;
import telran.performance.PerformanceTest;
import telran.text.JoinStrings;
import telran.text.JoinStringsOnBuilder;
import telran.text.JoinStringsOnStandard;
import telran.text.JoinStringsOnString;

public class JoinStringsPerformanceAppl {
	static final int N_STRINGS = 1000;
	static final int N_RUNS = 10000;
	private static final String PATH = "telran.text.";

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		var arr = getBigArray();
		PerformanceTest[] tests = new PerformanceTest[args.length];

		for (int i = 0; i < tests.length; i++) {
			Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(PATH + args[i]);
			Constructor<JoinStrings> constructor = clazz.getConstructor();
			JoinStrings str = constructor.newInstance();

			tests[i] = new JoinStringsPerformanceTest(str.getClass().getSimpleName(), N_RUNS, arr, str);
			tests[i].run();
		}

	}


	private static String[] getBigArray() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "hello");
		return res;
	}
}
