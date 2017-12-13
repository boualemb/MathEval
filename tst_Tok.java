package MathExp;

public class tst_Tok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Token T = new Token("cos (x^2 + y)^2 + 10( x - y )^2 ");
	        System.out.println(T);
	        Token T1 = new Token("(x-1)^2 + 10(x^2+y)^2");
	        System.out.println(T1);
	}

}
