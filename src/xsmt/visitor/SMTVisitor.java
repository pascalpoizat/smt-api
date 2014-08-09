package xsmt.visitor;

import java.util.ArrayList;

import xsmt.command.ICommand;
import xsmt.expression.IExpression;

public abstract class SMTVisitor {

	public Object visitCommand(ICommand command) {
		return command.accept(this);
	}

	public Object visitExpression(IExpression expression) {
		return expression.accept(this);
	}

	public abstract Object visitExitCommand();

	public abstract Object visitPushCommand(int depth);

	public abstract Object visitPopCommand(int depth);

	public abstract Object visitCheckSatCommand();

	public abstract Object visitGetAssertionsCommand();

	public abstract Object visitGetProofCommand();

	public abstract Object visitGetUnsatCoreCommand();

	public abstract Object visitGeneralExpression(String expression);

	public abstract Object visitSetLogicCommand(String logicName);

	public abstract Object visitSetOptionCommand(String optionName, String value);

	public abstract Object visitGetValueCommand(ArrayList<String> names);

	public abstract Object visitDeclareFunCommand(String name,
			ArrayList<String> params, String description);

	public abstract Object visitDeclareSortCommand(String name, int params);

	public abstract Object visitDefineSortCommand(String name,
			ArrayList<String> params, String description);

	public abstract Object visitDeclareDatatypeCommand(
			ArrayList<String> params, String description);

	public abstract Object visitDefineFunCommand(String name, String type,
			ArrayList<String> params, String description);

	public abstract Object visitAssertCommand(IExpression term);

}
