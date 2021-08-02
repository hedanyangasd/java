/**
 * Author：何丹阳
 * Data：2018/11.1
 * Version：1.0
 * Function：盒子类 
 **/
package danyang.he.text001;

import java.math.BigDecimal;

public class Box extends Artifact implements SteelMadeable{
	private double longe;
	private double width;
	private double height;
	BigDecimal bg ;
	
	public Box(double longe,double width,double height){
		this.longe = longe;
		this.width= width;
		this.height = height;
	}
	
	public Box(){
		
	}
	
	@Override
	public double melt() {
		double money = longe*width*height*melt_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double mold() {
		double money = longe*width*height*mold_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double coldDown() {
		double money = longe*width*height*coldDown_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	@Override
	public double polish() {
		double money = longe*width*height*polish_price;
		bg = new BigDecimal(money);
		money = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return money;
	}

	
	public double getLonge() {
		return longe;
	}

	public void setLonge(double longe) {
		this.longe = longe;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double calculate() {
		return melt()+mold()+coldDown()+polish();
	}
	
	@Override
	public String show() {
		return "盒子：成本"+calculate()+"元";
	}

	
}
