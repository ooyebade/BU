
public class TestException {
	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception ex) {
			System.out.println("-----> exception happend");
		}
	}
	
}
