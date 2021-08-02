
/**
 * Author：何丹阳
 * Data：2018/11.1
 * Version：1.0
 * Function：锅类 
 **/

package danyang.he.text001;

import java.math.BigDecimal;

public class Wok extends Artifact implements  IronMadeable {
	private double radius;
	private double depth;
	BigDecimal bg;
	public Wok(){
		
	}
	 
	public Wok(double radius,double depth){
		this.radius = radius;
		this.depth = depth;
	}
	
	@Override
	public double burn() {
		double money = 3.14/3.0*(3*radius-depth)*depth*depth*burn_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double handMold() {
		double money = 3.14/3.0*(3*radius-depth)*depth*depth*handMold_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double polish() {
		double money = 3.14/3.0*(3*radius-depth)*depth*depth*polish_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	@Override
	public double calculate() {
		return burn()+handMold()+polish();
	}

	@Override
	public String show(){
		return ("锅：成本"+calculate()+"元");
	}

	
}
