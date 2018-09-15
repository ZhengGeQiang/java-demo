package com.zhengq.designpattern._08mediatorpattern.extend.impl;

import com.zhengq.designpattern._08mediatorpattern.extend.AbstractMediator;

/**
 * 具体中介者
 * 
 * @ClassName: Mediator
 * @Description: TODO
 * @author: Zhenggq
 * @date: 2018年5月8日 上午9:42:47
 */
public class Mediator extends AbstractMediator {

	/**
	 * 中介者最重要的方法
	 * <p>
	 * Title: execute
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @param objects
	 * @see AbstractMediator#execute(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public void execute(String str, Object... objects) {
		if (str.equals("purchase.buy")) {// 采购电脑
			this.buyComputer((Integer) objects[0]);
		} else if (str.equals("sale.sell")) {// 销售电脑
			this.sellComputer((Integer) objects[0]);
		} else if (str.equals("sale.offsel")) {// 折价销售
			this.offsell();
		} else if (str.equals("stock.clear")) {// 清仓处理
			this.clearStock();
		}
	}

	/**
	 * 采购电脑
	 * 
	 * @Title: buyComputer
	 * @Description: TODO
	 * @param: @param number
	 * @return: void
	 * @throws
	 */
	private void buyComputer(int number) {
		// 电脑的销售情况
		int saleStatus = super.sale.getSaleStatus();
		if (saleStatus > 80) {// 销售情况良好
			System.out.println("采购IBM电脑:" + number + "台");
			stock.increase(number);
		} else {// 销售情况不好
			int buyNumber = number / 2;// 折半采购
			System.out.println("采购IBM电脑:" + buyNumber + "台");
			super.stock.increase(buyNumber);
		}
	}

	/**
	 * 销售电脑
	 * 
	 * @Title: sellComputer
	 * @Description: TODO
	 * @param: @param number
	 * @return: void
	 * @throws
	 */
	private void sellComputer(int number) {
		if (super.stock.getStockNumber() < number) {// 库存数量不够销售
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}

	/**
	 * 折价销售电脑
	 * 
	 * @Title: offsell
	 * @Description: TODO
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void offsell() {
		System.out.println("折价销售IBM电脑" + super.stock.getStockNumber() + "台");
	}

	/**
	 * 清仓处理
	 * 
	 * @Title: clearStock
	 * @Description: TODO
	 * @param:
	 * @return: void
	 * @throws
	 */
	private void clearStock() {
		// 要求清仓
		super.sale.offSale();
		// 要求采购人员不要采购
		super.purchase.refuseBuyIBM();
	}

}
