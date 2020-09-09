package joyou;

import java.io.Serializable;
import java.util.StringTokenizer;

public class StringTok implements Serializable {
	private static int[] foot= new int [9];
	
	
	private int[] footff;
	private static int count = 0;
	public StringTok(){}
	
	
	
	
	public static int[] getFoot() {
		return foot;
	}


	public static void setFoot(int[] foot) {
		StringTok.foot = foot;
	}




	public int[] getFootff() {
		return foot;
	}


	public void setFootff(int[] footff) {
		this.footff = footff;
	}


	static {
		
		String s1 ="123.14568.147.164289.12689.1268.126.12.126";
		StringTok tok = new StringTok();
		
		
		
		tok.tok(s1);
		for(int i =0;i<9;i++) {
			foot[i]=(int)(foot[i]*100/count);//個數轉換百分率
//			System.out.println(i+1+":"+foot[i]);
		}
		
	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String s1 ="123.14568.147.164289";
//		StringTok tok = new StringTok();
//		
//		
//		
//		tok.tok(s1);
//		for(int i =0;i<9;i++) {
//			System.out.println(i+1+":"+foot[i]);
//		}
//		
//		
//	}




	

	
	
	//分割
	public void tok(String s1) {
		StringTokenizer st = new StringTokenizer(s1, ".");
		while (st.hasMoreElements()) {
//			System.out.println("Token:" + st.nextToken());
			String s =st.nextToken();
			
			eql(s);
			
			sub(s);
		}
	}
	
	
	//桑基圖
	public void sub(String s1) {
		for(int i=0;i<s1.length()-1;i++) {
			String s =s1.substring(i, i+2);
			System.out.println(s);
		}
	}
	
	//轉換漏斗
	public void eql(String s1) {
		for(int i=0;i< s1.length();i++) {
			count++;
			char s =s1.charAt(i);
			char ch = s;int a = ch - 48;
			switch(a) {
			case 1:
				foot[0]++;
				break;
			case 2:
				foot[1]++;
				break;	
			case 3:
				foot[2]++;
				break;
			case 4:
				foot[3]++;
				break;
			case 5:
				foot[4]++;
				break;
			case 6:
				foot[5]++;
				break;
			case 7:
				foot[6]++;
				break;
			case 8:
				foot[7]++;
				break;
			case 9:
				foot[8]++;
				break;
			}
		}
	}
}
