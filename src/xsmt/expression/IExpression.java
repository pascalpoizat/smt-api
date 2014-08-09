package xsmt.expression;

import xsmt.visitor.SMTVisitor;

public interface IExpression {
	public Object accept(SMTVisitor visitor);
}
