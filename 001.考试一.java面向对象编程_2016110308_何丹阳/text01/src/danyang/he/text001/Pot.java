
/**
 * Author：何丹阳
 * Data：2018/11.1
 * Version：1.0
 * Function：壶类 
 **/
package danyang.he.text001;

import java.math.BigDecimal;

public class Pot extends Artifact implements PotteryMadeabl {
	private double radius;
	BigDecimal bg;
	
	public Pot(){
		
	}
	
	@Override
	public double mold() {
		double money = (4/3.0)*3.14*radius*radius*radius*mold_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double firing() {
		double money = (4/3.0)*3.14*radius*radius*radius*firing_price;
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

	@Override
	public double calculate() {
		return mold()+firing();
	}

	@Override
	public String show() {
		return "壶：成本"+calculate()+"元";
	}
	
	

}
