package danyang.he.text001;
//物品用铁制作
public interface IronMadeable {
	double burn();//烧铁的成本
	double handMold();//计算手工打制的成本
	double polish();//计算打磨的成本。
	double burn_price=10.0;
	double handMold_price = 15.0;
	double polish_price = 10.0;
}
