package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Set_option implements ICommand {

	public Set_option(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	String name, value;
	
	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitSetOptionCommand(name, value);
	}

}