package xsmt.command;

import java.util.ArrayList;

import xsmt.visitor.SMTVisitor;

public class Define_fun implements ICommand {

	String name, description, type;
	ArrayList<String> params;
	
	public Define_fun(String name, String type, String description, ArrayList<String> params) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitDefineFunCommand(name, type, params, description);
	}

}
