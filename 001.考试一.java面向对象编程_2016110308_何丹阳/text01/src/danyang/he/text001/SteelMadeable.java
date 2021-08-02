package danyang.he.text001;

public interface SteelMadeable {
	double melt();//计算熔钢的成本
	double mold();//计算塑形成本
	double coldDown();//计算 冷却成型成本
	double polish();//计算打磨成本
	double melt_price=10.0;
	double mold_price=10.0;
	double coldDown_price=5.0;
	double polish_price=15.0;
}
