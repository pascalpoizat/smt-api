/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p/>
 * {description}
 * Copyright (C) 2013 Abderrahmane Feliachi, Université Paris Sud
 * contact: https://plus.google.com/112309258396642297676/posts
 * email: tbd
 */

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
