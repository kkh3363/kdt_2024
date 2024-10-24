package mymvc.models;

public class Calculator {
	private int n1;
	private int n2;
	private String op;
	/**
	 * @return the n1
	 */
	public int getN1() {
		return n1;
	}
	/**
	 * @param n1 the n1 to set
	 */
	public void setN1(int n1) {
		this.n1 = n1;
	}
	/**
	 * @return the n2
	 */
	public int getN2() {
		return n2;
	}
	/**
	 * @param n2 the n2 to set
	 */
	public void setN2(int n2) {
		this.n2 = n2;
	}
	/**
	 * @return the op
	 */
	public String getOp() {
		return op;
	}
	/**
	 * @param op the op to set
	 */
	public void setOp(String op) {
		this.op = op;
	}
	public long calc() {		
		long result = 0;
		switch(op) {
			case "+": result = n1+n2;break;
			case "-": result = n1-n2;break;
			case "/": result = n1/n2;break;
			case "*": result = n1*n2;break;
		}
		return result;
	}
}
