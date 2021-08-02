/**
 * Author:何丹阳
 * Date:2018-10-20
 * Version:2.0
 * function:直线类，判断两条直线是否平行或者相等
**/
package danyang.he.Line;

import java.math.BigDecimal;

public class Line2D {
	 private double A;
     private double B;
     private double C;
     private boolean legal=true; //直线是否合法
     
   //一般式 Ax+By+c=0
     public Line2D(double A,double B,double C){
    	 this.A=A;
    	 this.B=B;
    	 this.C=C;
     }
     
     //点斜式 y-y1=k(x-x1)
     public Line2D(Point2D p1,double k){
    	 if(k==Double.NEGATIVE_INFINITY ||k == Double.POSITIVE_INFINITY){
    		 System.out.println("平行y轴");   
         	this.A=1;
         	this.B=0;
      		this.C=-p1.getX();
    	 }
    	 else if(k==0){
    		 this.A=0;
    		 this.B=1;
    		 this.C=-p1.getY();
    	 }
    	 else{
    		 this.A=k;
    		 this.B=-1;
    		 // double a=mul(-k,p1.getX());
    		 //double c=addDouble(a,p1.getY());
    		 this.C=-k*p1.getX()+p1.getY();
    	 }
     }

     //两点式(y-y2)/(y1-y2)=(x-x2)/(x1-x2)    
     public Line2D(Point2D p1,Point2D p2){    	
    	 if(p1.getX() == p2.getX()&&p1.getY() != p2.getY()){
    		System.out.println("平行y轴");   
        	this.A=1;
        	this.B=0;
     		this.C=-p1.getX();
    	}
    	else if(p1.getX()!=p2.getX()&&p1.getY()==p2.getY()){
    		System.out.println("平行x轴");   
        	this.A=0;
        	this.B=1;
     		this.C=-p1.getY();
    	}
    	else{
    		double a=subDouble(p1.getY(),p2.getY());
    		this.A=a;
    		double b = subDouble(p2.getX(),p1.getX());
    		this.B=b;
    		double m = mul(p1.getX(),p2.getY());
    		double n = mul(p2.getX(),p1.getY());
    		double c = subDouble(m,n);
    		this.C=c;
    	}
     }
        

	//截距式x/a+y/b=1
     public Line2D(double a,double b){    //m,n为x轴，y轴的截距
    	if((Double.POSITIVE_INFINITY == b||Double.NEGATIVE_INFINITY == b)&&(Double.POSITIVE_INFINITY == a||Double.NEGATIVE_INFINITY == a)){
        		legal = false;
    	} 
    	else if((Double.POSITIVE_INFINITY == b||Double.NEGATIVE_INFINITY == b)&&(Double.POSITIVE_INFINITY != a||Double.NEGATIVE_INFINITY != a)){
    		System.out.println("x=c");   
    		this.A=1;
    		this.B=0;
    		this.C=-a;
    	} 
    	else if((Double.POSITIVE_INFINITY != b||Double.NEGATIVE_INFINITY != b)&&(Double.POSITIVE_INFINITY == a||Double.NEGATIVE_INFINITY == a)){
    		System.out.println("y=c");   
    		this.A=0;
    		this.B=1;
    		this.C=-b;
    	} 
    	else{ 
    		this.A=b;
    		this.B=a;
    		double c = mul(a,b);
    		this.C=-c;
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
		Line2D other = (Line2D) obj;
		
		//不合法都为false
		if(A==0&&B==0&&other.A==0&&other.B==0){
			return false;
		}
		if(A*other.B==B*other.A&&B*other.C==C*other.B&&A!=0&&B!=0&&C!=0){
			return true;
		}	
		if (Double.doubleToLongBits(A) != Double.doubleToLongBits(other.A))
			return false;
		if (Double.doubleToLongBits(B) != Double.doubleToLongBits(other.B))
			return false;
		if (Double.doubleToLongBits(C) != Double.doubleToLongBits(other.C))
			return false;
		if(!legal){
			return false;
		}
		return true;
	}

	//判断是否平行，斜率相等，截距不等
    public boolean isParallel(Line2D L){  	
    	//y+c=0
    	if(A==0 && L.A==0  && B != 0 && L.B != 0){
    			return true;
    	}
    	//x+c=0
    	else if(A!=0&&L.A!=0&&B==0&&L.B==0){
    			return true;
    	}
    	//x+y+c=0
    	else if(A!=0&&L.A!=0&&B!=0&&L.B!=0){
    		double m = mul(A,L.B);
    		double n = mul(L.A,B);
    		if(m==n){
    			return true;
    		}
    	}
    	//x=0
    	else if(A!=0&&L.A!=0&&C == 0&&L.C == 0&&B==0&&L.B==0){
    			return true;
    	}
    	//y=0
    	else if(A==0&&L.A==0&&C == 0&&L.C == 0&&B!=0&&L.B!=0){
    			return true;
    	}	
    	return false;
    }
         
    
	public double getA() {
		return A;
	} 
	public void setA(double A) {
		this.A = A;
	}
	public double getB() {
		return B;
	}
	public void setB(double B) {
		this.B = B;
	}
	public double getC() {
		return C;
	}
	public void setC(double C) {
		this.C = C;
	}

    public boolean isLegal() {
		return legal;
	}

	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	//直线输出
	public String show(){  //1.>> 2.>< 3.<< 4.<>
			return A+"x+"+B+"y+"+C+"=0";
	}
	
	//解决精度问题
     // 加法运算
    public static double addDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.add(p2).doubleValue();
    }


    //  减法运算
    public static double subDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

     // 乘法运算
    public static double mul(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.multiply(p2).doubleValue();
    }

     // 除法运算
    public static double div(double m1, double m2, int scale) {
        if (scale < 0) {//精确到几位
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
	
}
