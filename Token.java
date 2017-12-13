package MathExp;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Token {
    /**Nombre de lignes*/
    List<String> Tok= new ArrayList<String>();
    String exp;
    int Counter =0;

    Token () {

    }
    Token (String S) {
        this.exp = S;
        String numBuf;
        String opBuf;
        char CurrChar;
        int n = exp.length();
        int i = 0;
        boolean stopbigloop=false;
        while (i<n)
        {
            CurrChar = exp.charAt(i);
            if (CurrChar != ' ')
            {
                if (isNumeric(CurrChar))
                {
                    numBuf = "";
                    numBuf+= CurrChar;
                    
	                    ++i;
	                if(i<n) 
	                    CurrChar = exp.charAt(i);
	                else
	                	{
	                		Tok.add(numBuf);
	                		break;
	                	}
	                	
	                    while (isNumeric(CurrChar) && i<n)
	                    {
	                        numBuf+= CurrChar;
	                        ++i;
	                        if(i<n)
	                        	CurrChar = exp.charAt(i);
	                        else {
		                		Tok.add(numBuf);
		                		stopbigloop=true;
		                		break;
		                		
		                	}
	                    }
	                    if (stopbigloop) break;
	                    if (CurrChar == '.' || CurrChar == ',' )
	                    {
	                        numBuf+= '.';
	                        ++i;
	                        if(i<n)
	                        	CurrChar = exp.charAt(i);
	                        else {
		                		Tok.add(numBuf);
		                		break;
		                	}
	                    }
	                    
	                    while (isNumeric(CurrChar) && i<n)
	                    {
	                        numBuf+= CurrChar;
	                        ++i;
	                        if(i<n)
	                        	CurrChar = exp.charAt(i);
	                        else {
		                		Tok.add(numBuf);
		                		stopbigloop=true;
		                		break;
		                	}
	                    }
                    if (stopbigloop) break;
                    Tok.add(numBuf);
                    Counter++;
                }
                if (isOperator(CurrChar))
                {
                    Tok.add(String.valueOf(CurrChar));
                    Counter++;
                }
                if (isParenthese(CurrChar))
                {
                    Tok.add(String.valueOf(CurrChar));
                    Counter++;
                }
                if (isVariable(CurrChar))
                {
                    Tok.add(String.valueOf(CurrChar));
                    Counter++;
                }
                if (isLetter(CurrChar))
                {
                	opBuf = "";
                	opBuf+= CurrChar;
                    
	                    ++i;
	                if(i<n) 
	                    CurrChar = exp.charAt(i);
	                else
	                	{
	                		Tok.add(opBuf);
	                		break;
	                	}
	                	
	                    while (isLetter(CurrChar) && i<n)
	                    {
	                    	opBuf+= CurrChar;
	                        ++i;
	                        if(i<n)
	                        	CurrChar = exp.charAt(i);
	                        else {
		                		Tok.add(opBuf);
		                		stopbigloop=true;
		                		break;
		                		
		                	}
	                    }
	                    if (stopbigloop) { 
	                    	break;
	                    	}
	                    
	                    Tok.add(opBuf);
                  --i;
                }

            }
            ++i;
        }

    }
    Token (Token T)
    {

    }
    boolean isNumeric (char c)
    {
        String num= "0123456789";
        for (int i =0; i<num.length();++i) {
            if (c == num.charAt(i))
                return true;
        }
        return false;

    }
    boolean isOperator (char c)
    {
        String num= "+-*/^";
        for (int i =0; i<num.length();++i) {
            if (c == num.charAt(i))
                return true;
        }
        return false;

    }
    boolean isParenthese (char c)
    {
        String num= "()";
        for (int i =0; i<num.length();++i) {
            if (c == num.charAt(i))
                return true;
        }
        return false;

    }
    boolean isVariable (char c)
    {
        String num= "xyz";
        for (int i =0; i<num.length();++i) {
            if (c == num.charAt(i))
                return true;
        }
        return false;

    }
    boolean isLetter(char c)
    {
    	String alp = "cosintah";
    	for (int i =0; i<alp.length();++i) {
            if (c == alp.charAt(i))
                return true;
        }
    	return false;
    }
    public String toString ()
    {
        String s="";
        ListIterator it = Tok.listIterator();
        while (it.hasNext())
        {
            s+=it.next()+"\n";
        }


        return s;
    }

}