package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Pop implements ICommand {

	public Pop(int depth) {
		super();
		this.depth = depth;
	}

	int depth;
	
	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitPopCommand(depth);
	}
}
