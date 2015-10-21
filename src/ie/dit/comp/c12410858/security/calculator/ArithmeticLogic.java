package ie.dit.comp.c12410858.security.calculator;

/**
 * Class for recording and counting the total and how work is done on that total
 * @author Alan
 *
 */
public class ArithmeticLogic {

	private Double total;

	public ArithmeticLogic() {
		total = 0.0;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	public void add(Double n) {
		total += n;
	}

	public void subtract(Double n) {
		total -= n;
	}

	public void multiply(Double n) {
		total *= n;
	}

	public void divide(Double n) {
		total /= n;
	}
	
	public void clear() {
		total = 0.0;
	}
	
	public Double getTotal(){
		return total;
	}
	
	public String getTotalAsString() {
		return Double.toString(total);
	}

}