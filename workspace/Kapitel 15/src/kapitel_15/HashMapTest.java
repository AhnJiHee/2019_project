package kapitel_15;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
			String [] p1 =  {"010-2222-3333", "02-3429-6666",
					"031-222-9999", "kim@multi.com"};
			String [] p2 = {"010-6789-2345", "051-666-9999",
					"song@multi.com"};
			String [] p3 = {"010-5555-0102", "02-456-9909", "jun@multi.com"};
			
			HashMap<String, String []> map = new HashMap<String, String []>();
			map.put("김태리", p1);
			map.put("송혜교", p2);
			map.put("전지현", p3);
			map.put("이자바", p1);
			
			//map 내부의 모든 키값 조회하기
			//키값은 중복되지 않으므로 셋으로 설정
			Set<String> keys = map.keySet();
			for (String k : keys) {
				String [] result = map.get(k);
				System.out.print(k + " - ");
				for ( String s : result) {
					System.out.print(s + " & ");
				}
				System.out.println();
			}
			

		/*
		 * class HashMap implements Map{
		 * put(Object k, Object v)
		 * Object <-- get(Object k)
		 * }
		 * 
		 * class HashMap<T1, T2> implements Map{
		 * put(T1 k, T2 v)
		 * T2 <-- get (T1 k)
		 *}
		 *
		 *24명의 점수를 저장하는데
		 *1) 동점이 나올 수 있다 : ArrayList
		 *2) 동점이 나오지 않는다 : HashSet
		 *3) 교육생 코드와 점수를 매치하고 싶다 : HashMap
		 * */
		

	}

}
