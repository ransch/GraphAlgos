package shared;

import java.util.Arrays;
import java.util.Comparator;

public class AlgorithmsService {

	private final static AlgorithmsService INSTANCE = new AlgorithmsService();

	private SortService sortService;

	private AlgorithmsService() {
		sortService = Arrays::sort;
	}

	public static AlgorithmsService Algos() {
		return INSTANCE;
	}

	public <T> void sort(T[] a, Comparator<? super T> c) {
		sortService.sort(a, c);
	}

	public void setSortService(SortService sortService) {
		this.sortService = sortService;
	}

	@FunctionalInterface
	public interface SortService {
		<T> void sort(T[] a, Comparator<? super T> c);
	}
}