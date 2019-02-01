package chap12;

class B implements Runnable{
	String msg;
	B(String msg){
		this.msg = msg;
	}
	public void run() {
		for (int i = 1; i<=20;i++) {
			try {
				Thread.sleep(500);
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			System.out.println(msg +":"+i);
		}
	}
}
public class RunnableTest1 {
public static void main(String[] args) {
	B a1 = new B("one");
	B a2 = new B("two");
	Thread t1 = new Thread(a1);
	Thread t2 = new Thread(a2);
	t1.start();
	t2.start();
}
}
