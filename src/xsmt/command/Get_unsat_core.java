package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Get_unsat_core implements ICommand {

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitGetUnsatCoreCommand();
	}

}
