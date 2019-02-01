package kapitel_15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		//1) set 데이터 저장
		Set<Integer> lotto = new HashSet<Integer> (6);
		while (true) {
			int ran =(int)(Math.random()*45)+1;
			lotto.add(ran);
			System.out.println(ran + ":" + lotto.size());
			if(lotto.size() == 6) break;
		}
		System.out.println("===================================");

		//2) set 데이터 조회
		Iterator<Integer> it = lotto.iterator();
		while (it.hasNext()) {
			Integer in = it.next();
			System.out.println(in);
		}
		System.out.println("===================================");
		
		//3) set 데이터 조회 2 (jdk 1.5 이후 추가)
		for ( Integer i : lotto) {
			System.out.println(i);
		}
		
		
		
		
		
		
		/*
		 * class HashSet implements Set{
		 * add(Object o) {o의 저장 여부 판단, 없다면 add / 있다면 add 무시}
		 * 인덱스가 없으므로 get메소드가 없다
		 * iterator : "반복자"
		 * size()
		 * }
		 * ex)로또번호
		 * */
	}

}
