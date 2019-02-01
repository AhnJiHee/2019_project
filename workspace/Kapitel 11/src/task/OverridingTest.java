package task;

class OverridingTest {
    public static void main(String args[]){
        int i = 10;
        int j = 20;
        
        MySum ms1 = new MySum(i, j);
        MySum ms2 = new MySum(j, i);

        System.out.println(ms1);
        System.out.println(ms2);
        // toString을 오버라이딩해서 int값이 출력되도록 (i+j)
        // 둘다 30이 나오도록
        // 두 매개변수에 i, j 할당해서 더한 값 출력

        if(ms1.equals(ms2))
            System.out.println
("ms1과 ms2의 합계는 동일합니다.");
        // equals 오버라이딩해서 ms1과 ms2"값이" 같으면 다음 출력
    }
}

class MySum {
    int first;
    int second;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }

    // toString() override
	public String toString() {
		return String.valueOf(first+second);
	}

	// equals() override
	public boolean equals(Object obj) {
		
	if (obj instanceof MySum) {
			return toString().equals(obj.toString());
			// toString은 이미 오버라이드 됐기 때문에 obj를 형변환할 필요가 없다.
		}
	else {return false;}
	}
}

//<출력결과>
//
//30
//30
//ms1과 ms2의 합계는 동일합니다.


