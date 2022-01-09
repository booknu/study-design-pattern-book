package direct_implementation.observer;

public interface Observable<T> {
	void addObserver(Observer<T> observer);

	boolean removeObserver(Observer<T> observer);

	void notifyObservers();

	T getData();
}
