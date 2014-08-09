package xsmt.solver;
import xsmt.command.ICommand;
import xsmt.response.IResponse;
import xsmt.visitor.SMTVisitor;


public abstract class ISolver {
	
	protected SMTVisitor visitor;
	protected String path;
	
	public ISolver(SMTVisitor visitor, String path){
		this.visitor = visitor;
		this.path = path;
	}
	
	public abstract IResponse start();
	
	public abstract IResponse execute(ICommand command);
}
