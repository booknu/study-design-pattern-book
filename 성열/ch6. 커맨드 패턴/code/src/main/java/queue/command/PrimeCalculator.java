package queue.command;

import queue.exception.ObjectNotReadyException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator extends SynchronizedCommand {
	private final int range;
	private int[] smallestPrimeFactor;
	private List<Integer> primes;

	public PrimeCalculator(int range) {
		super();
		this.range = range;
	}

	@Override
	protected void synchronizedExecute() {
		System.out.println(this.getClass().getSimpleName());
		smallestPrimeFactor = new int[range];
		primes = new ArrayList<>();

		for (int x = 2; x < range; ++x) {
			if (smallestPrimeFactor[x] == 0) {
				smallestPrimeFactor[x] = x;
				primes.add(x);
			}

			for (int i = 0; x * primes.get(i) < range; ++i) {
				smallestPrimeFactor[x * primes.get(i)] = primes.get(i);
				if (x % primes.get(i) == 0) break;
			}
		}
	}

	public boolean ready() {
		return afterReadLock(() -> smallestPrimeFactor != null);
	}

	public List<Integer> fractionalDecomposition(int x) {
		return afterReadLock(() -> {
			if (!ready()) {
				throw new ObjectNotReadyException("object not ready");
			}

			if (x <= 0 || x >= range) {
				throw new InvalidParameterException("number out of range : x=" + x + ", range=" + range);
			}

			int n = x;
			List<Integer> result = new ArrayList<>();

			while(n > 1) {
				result.add(smallestPrimeFactor[n]);
				n /= smallestPrimeFactor[n];
			}

			return result;
		});
	}
}
