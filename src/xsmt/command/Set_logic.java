package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Set_logic implements ICommand {

	String logicName;
	
	public Set_logic(String logicName) {
		super();
		this.logicName = logicName;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitSetLogicCommand(logicName);
	}

}
