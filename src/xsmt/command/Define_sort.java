package xsmt.command;

import java.util.ArrayList;

import xsmt.visitor.SMTVisitor;

public class Define_sort implements ICommand {

	String name, description;
	ArrayList<String> params;
	
	public Define_sort(String name, String description, ArrayList<String> params) {
		super();
		this.name = name;
		this.description = description;
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitDefineSortCommand(name, params, description);
	}

}
