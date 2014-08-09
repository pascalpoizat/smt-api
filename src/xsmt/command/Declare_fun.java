package xsmt.command;

import java.util.ArrayList;

import xsmt.visitor.SMTVisitor;

public class Declare_fun implements ICommand {

	String name, description;
	ArrayList<String> params;
	
	public Declare_fun(String name, String description, ArrayList<String> params) {
		super();
		this.name = name;
		this.description = description;
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitDeclareFunCommand(name, params, description);
	}

	
}
