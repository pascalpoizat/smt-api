package xsmt.response;

public class BasicResponse implements IResponse {

	String text;
	
	public BasicResponse(String text) {
		super();
		this.text = text;
	}

	public String toString(){
		return text;
	}
	
}
