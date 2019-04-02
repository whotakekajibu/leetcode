package singleton;

public class Singleton {
	private Singleton() {
	}

	public static class Holder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return Holder.INSTANCE;
	}

}
