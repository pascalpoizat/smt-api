package xsmt.expression;

import xsmt.visitor.SMTVisitor;

public class Expression implements IExpression {

	String expression;
	
	public Expression(String expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitGeneralExpression(expression);
	}
	
	public String toString(){
		return expression;
	}

}
