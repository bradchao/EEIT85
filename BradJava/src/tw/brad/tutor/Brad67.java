package tw.brad.tutor;

public class Brad67 {
	public static void main(String[] args) {
		Brad672 obj1 = new Brad672();
	}
}
class Brad671{
	static {System.out.println("Brad671:static{}");}
	{System.out.println("Brad671:{}");}
	
	Brad671(){System.out.println("Brad671()");}
	
	static void m2() {System.out.println("Brad671:static m2()");}
	void m1() {System.out.println("Brad671:m1()");}
}
class Brad672 extends Brad671 {
	static {System.out.println("Brad672:static{}");}
	
}