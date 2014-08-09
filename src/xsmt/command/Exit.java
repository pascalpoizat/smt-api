package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Exit implements ICommand {

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitExitCommand();
	}

	
}
