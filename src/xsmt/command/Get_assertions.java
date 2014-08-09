package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Get_assertions implements ICommand {

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitGetAssertionsCommand();
	}

	
}
