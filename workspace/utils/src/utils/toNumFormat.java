package utils;

import java.text.DecimalFormat;

/**
 * 숫자에 천단위마다 콤마 넣기
 * @param int
 * @return String
 * */

public class toNumFormat {
	 public static String toNumFormat(int num) {
		  DecimalFormat df = new DecimalFormat("#,###");
		  return df.format(num);
	 }
}


