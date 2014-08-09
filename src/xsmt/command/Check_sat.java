package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Check_sat implements ICommand {

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitCheckSatCommand();
	}

	
}
