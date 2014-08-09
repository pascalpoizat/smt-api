package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Get_proof implements ICommand {

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitGetProofCommand();
	}

	
}
