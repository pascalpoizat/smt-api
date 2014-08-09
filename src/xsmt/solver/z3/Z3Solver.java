package xsmt.solver.z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import xsmt.command.Exit;
import xsmt.command.ICommand;
import xsmt.command.Set_option;
import xsmt.response.BasicResponse;
import xsmt.response.IResponse;
import xsmt.solver.ISolver;

public class Z3Solver extends ISolver {

	OutputStream stdin = null;
	InputStream stderr = null;
	InputStream stdout = null;
	Process process = null;
	BufferedReader outbr = null;
	BufferedReader errbr = null;
	private boolean started = false;

	public Z3Solver(String path) {
		super(new Z3SMTVisitor(), path);
		started = false;
	}

	@Override
	public IResponse start() {

		if(started)
			return new BasicResponse("solver alerady started");
		try {
			// path =
			// "C:\\Program Files (x86)\\Microsoft Research\\Z3-3.2\\bin\\z3.exe /si /smtc /m";
			//ProcessBuilder builder = new ProcessBuilder(path + " /si /smt2 /m");
			//builder.redirectErrorStream(true);
			//process = builder.start();

			
			//if(System.getProperty("os.name").contains("windows") || System.getProperty("os.name").contains("Windows"))
			//	process = Runtime.getRuntime().exec(path + " /si /smt2 /m");
			//else
			{
				//System.out.println(path + " -si -smt2 -m");
				process = Runtime.getRuntime().exec(path + " -in -smt2 -nw");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stdin = process.getOutputStream();
		stderr = process.getErrorStream();
		stdout = process.getInputStream();
		
		outbr = new BufferedReader(
				new InputStreamReader(stdout));
		
		errbr = new BufferedReader(new InputStreamReader(stderr));
		started = true;
		
		
		String line = visitor.visitCommand(new Set_option("print-success", "true")).toString()+"\n";
		try {
			stdin.write(line.getBytes());
			stdin.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return new BasicResponse("success");
	}

	@Override
	public IResponse execute(ICommand command) {
		if(!started)
			return new BasicResponse("solver must be started first");
		String result = "", line;
		try {

			line = visitor.visitCommand(command).toString()+"\n";
			//fr.lri.schora.util.Debug.print("command: "+line);
			stdin.write(line.getBytes());
			stdin.flush();
			
			
			
			while((!outbr.ready()) && (!errbr.ready()))
				continue;
			
			while (outbr.ready()) {
				 line = outbr.readLine();
				 if (line == null)
					 break;
				result += line;
			}

			line = null;
			if (errbr.ready() && (line = errbr.readLine()) != null) {
				//fr.lri.schora.util.Debug.println ("[Stderr] " + line);
				result += line;
			}

			if (command instanceof Exit) {
				stdin.close();
				outbr.close();
				errbr.close();
				process.destroy();
				started = false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		//fr.lri.schora.util.Debug.println ("response: " + result);		
		return new BasicResponse(result);
	}

}
