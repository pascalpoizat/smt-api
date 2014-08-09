package xsmt.command;

import java.util.ArrayList;

import xsmt.visitor.SMTVisitor;

public class Get_value implements ICommand {

	ArrayList<String> params;

	public Get_value(ArrayList<String> params) {
		super();
		this.params = params;
	}

	@Override
	public Object accept(SMTVisitor visitor) {
		return visitor.visitGetValueCommand(params);
	}

}
