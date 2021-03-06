package com.zhengq.designpattern._01singletonpattern.generalcode;

/**
 * <p>推荐使用这种模式的单例<br>
 * 单例模式通用代码,饿汉式单例
 * @ClassName:       Singleton
 * @Description:     
 *  <p>单例模式的优点<br>
 *  ▪  由于单例模式在内存中只有一个实例，减少了内存开支，特别是一个对象需要频繁地创建、销毁时，而且创建或销毁时性能又无法优化，单例模式的优势就非常明显。<br>
 *	▪  由于单例模式只生成一个实例，所以减少了系统的性能开销，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，<br>
 *     则可以通过在应用启动时直接产生一个单例对象，然后用永久驻留内存的方式来解决（在Java EE中采用单例模式时需要注意JVM垃圾回收机制）。<br>
 *	▪  单例模式可以避免对资源的多重占用，例如一个写文件动作，由于只有一个实例存在内存中，避免对同一个资源文件的同时写操作。<br>
 *	▪  单例模式可以在系统设置全局的访问点，优化和共享资源访问，例如可以设计一个单例类，负责所有数据表的映射处理。<br>
 *
 *	<p>单例模式的缺点<br>
 *	▪  单例模式一般没有接口，扩展很困难，若要扩展，除了修改代码基本上没有第二种途径可以实现。单例模式为什么不能增加接口呢？<br>
 *	        因为接口对单例模式是没有任何意义的，它要求“自行实例化”，并且提供单一实例、接口或抽象类是不可能被实例化的。当然，在特殊情况下，单例模式可以实现接口、被继承等，需要在系统开发中根据环境判断。<br>
 *	▪  单例模式对测试是不利的。在并行开发环境中，如果单例模式没有完成，是不能进行测试的，没有接口也不能使用mock的方式虚拟一个对象。<br>
 *	▪  单例模式与单一职责原则有冲突。一个类应该只实现一个逻辑，而不关心它是否是单例的，是不是要单例取决于环境，单例模式把“要单例”和业务逻辑融合在一个类中。<br>
 *
 *  <p>最佳实践<br>
 *  ▪  单例模式是23个模式中比较简单的模式，应用也非常广泛，如在Spring中，每个Bean默认就是单例的，这样做的优点是Spring容器可以管理这些Bean的生命期，决定什么时候创建出来，什么时候销毁，销毁的时候要如何处理，等等。<br>
 *     如果采用非单例模式（Prototype类型），则Bean初始化后的管理交由J2EE容器，Spring容器不再跟踪管理Bean的生命周期。
 * @author:          Zhenggq
 * @date:            2018年5月3日        下午3:05:41
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();

	// 限制多个对象
	private Singleton() {

	}

	// 通过该方法获得实例,synchronized保证线程安全
	public static synchronized Singleton getSingleton() {
		return singleton;
	}

	// 类中其它方法，尽量是static
	public static void doSomething() {

	}
}
