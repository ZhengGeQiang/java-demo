package com.zhengq.designpattern._02factorypattern.extend.multifactory;

import com.zhengq.designpattern._02factorypattern.example.Human;
import com.zhengq.designpattern._02factorypattern.example.impl.BlackHuman;

public class BlackHumanFactory extends AbstractHumanFactory {

	@Override
	public Human createHuman() {
		return new BlackHuman();
	}

}
