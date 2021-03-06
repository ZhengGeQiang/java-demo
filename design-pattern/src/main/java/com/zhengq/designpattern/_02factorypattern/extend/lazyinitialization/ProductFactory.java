package com.zhengq.designpattern._02factorypattern.extend.lazyinitialization;

import java.util.HashMap;
import java.util.Map;

import com.zhengq.designpattern._02factorypattern.generalcode.ConcreteProduct1;
import com.zhengq.designpattern._02factorypattern.generalcode.ConcreteProduct2;
import com.zhengq.designpattern._02factorypattern.generalcode.Product;

/**
 * 延迟加载的工厂类
 * 
 * @ClassName: ProductFactory
 * @Description: 
 * ▪  延迟加载框架是可以扩展的，例如限制某一个产品类的最大实例化数量，可以通过判断Map中已有的对象数量来实现，这样的处理是非常有意义的，例如JDBC连接数据库，都会要求设置一个MaxConnections最大连接数量，该数量就是内存中最大实例化的数量。<br>
 * ▪  延迟加载还可以用在对象初始化比较复杂的情况下，例如硬件访问，涉及多方面的交互，则可以通过延迟加载降低对象的产生和销毁带来的复杂性。
 * @author: Zhenggq
 * @date: 2018年5月3日 下午5:25:01
 */
public class ProductFactory {
	private static final Map<String, Product> proMap = new HashMap<String, Product>();

	public static synchronized Product createProduct(String type) throws Exception {
		Product product = null;
		if (proMap.containsKey(type)) {
			product = proMap.get(type);
		} else {
			if (type.equals("Product1")) {
				product = new ConcreteProduct1();
			} else {
				product = new ConcreteProduct2();
			}
			proMap.put(type, product);
		}
		return product;
	}
}
