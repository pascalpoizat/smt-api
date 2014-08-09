package xsmt.command;

import java.util.ArrayList;

import xsmt.visitor.SMTVisitor;

public class Declare_datatype implements ICommand {

	String description;
	ArrayList<String> params;
	
	public Declare_datatype(String description, ArrayList<String> params) {
		super();
		this.description = description;
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitDeclareDatatypeCommand(params, description);
	}

}
