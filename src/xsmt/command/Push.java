package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Push implements ICommand {

	public Push(int depth) {
		super();
		this.depth = depth;
	}

	int depth;
	
	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitPushCommand(depth);
	}

}
