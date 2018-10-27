package algorithms;

/**
 * This class wraps several functional interfaces that are used several
 * algorithms.
 */
/* package */ class Functions {

	/**
	 * This interface wraps a function with one parameter.
	 * 
	 * @param <T> The type of the (only) argument
	 * @param <R> The return type
	 */
	@FunctionalInterface
	/* package */ interface Function1Par<T, R> {
		R run(T a);
	}

	/**
	 * This interface wraps a function with two parameters.
	 * 
	 * @param <T> The type of the first argument
	 * @param <S> The type of the second argument
	 * @param <R> The return type
	 */
	@FunctionalInterface
	/* package */ interface Function2Par<T, S, R> {
		R run(T a, S b);
	}

	/**
	 * This interface wraps a function with zero parameters.
	 * 
	 * @param <R> The return type
	 */
	@FunctionalInterface
	/* package */ interface Function0Par<R> {
		R run();
	}

	/**
	 * This interface wraps a function with two parameters.
	 * 
	 * @param <T> The type of the first argument
	 * @param <S> The type of the second argument
	 */
	@FunctionalInterface
	/* package */ interface Void2Par<T, S> {
		void run(T a, S b);
	}
}