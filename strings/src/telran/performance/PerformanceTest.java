package telran.performance;

public abstract class PerformanceTest {
	String testName;
	int nRuns;
	
	protected abstract void runTest();
	
	public PerformanceTest(String testName, int nRuns) {
		this.testName = testName;
		this.nRuns = nRuns;
	}
	
	public void run() {
		var cur = System.currentTimeMillis();
		
		for (int i = 0; i < nRuns; i++) {
			runTest();
		}	
		var dif = System.currentTimeMillis() - cur;
		System.out.printf("%s: %ds, %d runs\n", testName, dif, nRuns);
		
	}
}
