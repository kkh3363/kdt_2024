package chap11;


import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenPrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "of the people, by the people, for the people";

        try {
            showTokens(s, ", ");
        } catch (NoSuchElementException e) {
            System.out.println("끝");
        }
	}
	public static void showTokens(String s, String delim) throws NoSuchElementException {
		String token;
        StringTokenizer st = new StringTokenizer(s, ",");
        
        while ( st.hasMoreTokens() ) {
        	StringTokenizer subToken = new StringTokenizer(st.nextToken().trim(), " ");
        	while ( subToken.hasMoreTokens())
        		System.out.println("[" + subToken.nextToken() + "]");
		}
	}

}
