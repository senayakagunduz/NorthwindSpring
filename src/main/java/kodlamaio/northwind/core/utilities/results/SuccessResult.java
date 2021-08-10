package kodlamaio.northwind.core.utilities.results;

public class SuccessResult extends Result{
	public SuccessResult() {
		super(true);// eğer super i kullanmazsan üsr sınıfın constructorını kullanamayız.super ile üst sınıfa true bilgisini verdik yani success olacak fakat message vermeyecek.
	}
	public SuccessResult(boolean success, String message) {
		super(true, message);
		
	}
	
	public SuccessResult(String message) {
		super(true,message);
	}
	
		
	
	

}
