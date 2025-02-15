package srtnglgrthms.model.algorithm.raw;

import srtnglgrthms.controller.BenchmarkController;
import srtnglgrthms.model.algorithm.SortingAlgorithm;

/**
 *
 * @author <a href="mailto:marfoldi@caesar.elte.hu">M�rf�ldi P�ter Bence</a>
 */
public class InsertionSortThread extends SortingThread {
	@Override
	public void doRun() {
		numbers = new int[SortingAlgorithm.getNumbers().length];
		System.arraycopy(SortingAlgorithm.getNumbers(), 0, numbers, 0,
				SortingAlgorithm.getNumbers().length);
		for (int i = 0; i < numbers.length - 1; i++) {
			int temp = numbers[i + 1];
			int j;
			for (j = i; j >= 0; --j) {
				comparisonCounter++;
				if (temp < numbers[j]) {
					moveCounter++;
					numbers[j + 1] = numbers[j];
				} else {
					break;
				}
			}
			numbers[j + 1] = temp;
		}
		BenchmarkController.addBenchmarkData(new BenchmarkData("Besz�r� rendez�s",
				comparisonCounter, moveCounter, 0));
	}

}
