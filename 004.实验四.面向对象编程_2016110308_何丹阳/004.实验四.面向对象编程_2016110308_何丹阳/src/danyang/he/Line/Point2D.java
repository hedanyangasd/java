/**
 * Author:何丹阳
 * Date:2018-10-25
 * Version:2.0
 * function:点类，有点的横纵坐标，判断两个点是否相等
**/
package danyang.he.Line;

public class Point2D {
	 private double x;    //横坐标
     private double y;    //纵坐标
     private boolean legal=true; //是否合法点
     
     public Point2D(double x,double y){    //构造函数
    	 if(x==Double.NEGATIVE_INFINITY||x==Double.POSITIVE_INFINITY||y==Double.NEGATIVE_INFINITY||y==Double.POSITIVE_INFINITY){
     		legal=false;
     	 }    	 
     	 else{
     		 this.x=x;
     		 this.y=y;
     	 }
    }
     	
     
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if(!legal){
			return false;
		}
	
		return true;
	}

	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setX(double x) {
		this.x = x;
	}	
}
