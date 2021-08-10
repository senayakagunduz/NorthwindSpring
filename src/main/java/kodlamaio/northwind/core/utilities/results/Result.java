package kodlamaio.northwind.core.utilities.results;

public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success=success;
	}
	
    public Result(boolean success,String message) {
		this(success);
		this.message=message;
	}
    public boolean isScuccess() { //getter metodu aslında getsuccess ama onun yerine genellikle isSuccess kullanılıyormuş.
    	return this.success;
    }
    public String getMessage() {
    	return this.message;
    }
    

}
