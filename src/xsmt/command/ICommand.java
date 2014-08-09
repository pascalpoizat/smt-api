package xsmt.command;

import xsmt.visitor.SMTVisitor;

public interface ICommand {
	public Object accept(SMTVisitor visitor);
}
