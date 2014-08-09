package xsmt.command;

import xsmt.visitor.SMTVisitor;

public class Declare_sort implements ICommand {

	String name;
	int params;
	
	public Declare_sort(String name, int params) {
		super();
		this.name = name;
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitDeclareSortCommand(name, params);
	}

	
}
