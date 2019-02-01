package chap12;

class A extends Thread{
	String msg;
	A(String msg){
		this.msg = msg;
	}
	public void run() {
		for (int i = 1; i<=10;i++) {
			try {
			sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(msg +":"+i);
		}
	}
}

public class ThreadTest1 {
public static void main(String[] args) {
	A a1 = new A("one");
	A a2 = new A("two");
	a1.start();
	a2.start();
}
}
