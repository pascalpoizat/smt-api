package xsmt.command;

import xsmt.expression.IExpression;
import xsmt.visitor.SMTVisitor;

public class Assert implements ICommand {

	IExpression term;
	public Assert(IExpression term) {
		super();
		this.term = term;
	}
	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitAssertCommand(term);
	}

}
