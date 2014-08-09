package xsmt.solver.z3;

import java.util.ArrayList;

import xsmt.expression.IExpression;
import xsmt.visitor.SMTVisitor;

public class Z3SMTVisitor extends SMTVisitor {

	@Override
	public String visitExitCommand() {
		return "(exit)";
	}

	@Override
	public String visitPushCommand(int depth) {
		return "(push " + depth + ")";
	}

	@Override
	public String visitPopCommand(int depth) {
		return "(pop " + depth + ")";
	}

	@Override
	public String visitCheckSatCommand() {
		return "(check-sat)";
	}

	@Override
	public String visitGetAssertionsCommand() {
		return "(get-assertions)";
	}

	@Override
	public String visitGetProofCommand() {
		return "(get-proof)";
	}

	@Override
	public String visitGetUnsatCoreCommand() {
		return "(get-unsat-core)";
	}

	@Override
	public String visitGeneralExpression(String expression) {
		return "(" + expression + ")";
	}

	@Override
	public String visitSetLogicCommand(String logicName) {
		return "(set-logic " + logicName + ")";
	}

	@Override
	public String visitGetValueCommand(ArrayList<String> params) {
		return "(get-value (" + printExpressions(params) + "))";
	}

	private String printExpressions(ArrayList<String> params) {
		String result = "";
		for (String ex : params) {
			result += " " + ex;
		}
		return result;
	}

	@Override
	public String visitDeclareFunCommand(String name, ArrayList<String> params,
			String description) {
		return "(declare-fun " + name + " (" + printStrings(params) + ") "
				+ description + ")";
	}

	private String printStrings(ArrayList<String> params) {
		String result = "";
		for (String param : params) {
			result += "(" + param + ")";
		}
		return result;
	}

	@Override
	public String visitDeclareSortCommand(String name, int params) {
		return "(declare-sort " + name + " " + params + ")";
	}

	@Override
	public String visitDefineSortCommand(String name, ArrayList<String> params,
			String description) {
		return "(define-sort " + name + " (" + printStrings(params) + ") "
				+ description + ")";
	}

	@Override
	public String visitDeclareDatatypeCommand(ArrayList<String> params,
			String description) {
		if (params != null && !params.isEmpty())
			return "(declare-datatypes (" + printStrings(params) + ") ("
					+ description + "))";
		else
			return "(declare-datatypes () (" + description + "))";
	}

	@Override
	public String visitDefineFunCommand(String name, String type,
			ArrayList<String> params, String description) {
		return "(define-fun " + name + " (" + printStrings(params) + ") "
				+ type + " " + description + ")";
	}

	@Override
	public Object visitAssertCommand(IExpression term) {
		return "(assert " + term + ")";
	}

	@Override
	public Object visitSetOptionCommand(String optionName, String value) {
		return "(set-option :" + optionName + " " + value + ")";
	}

}
