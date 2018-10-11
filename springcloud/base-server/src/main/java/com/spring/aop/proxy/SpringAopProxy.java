package com.spring.aop.proxy;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * 1.织入(Weaving)
 * 把切面应用到目标对象来创建新的代理对象的过程
 * 织入一般发生在如下几个时机:
 * <p>
 * (1)编译时：当一个类文件被编译时进行织入，这需要特殊的编译器才可以做的到，例如AspectJ的织入编译器
 * (2)类加载时：使用特殊的ClassLoader在目标类被加载到程序之前增强类的字节代码
 * (3)运行时：切面在运行的某个时刻被织入,SpringAOP就是以这种方式织入切面的，原理应该是使用了JDK的动态代理技术
 * <p>
 * 2.代理(proxy)
 * 应用通知的对象
 * 3.目标(Target)
 * 被通知的对象
 *
 * 如果不同切面需要在同一个连接点进行处理:
 * 1.可以让切面实现org.springframework.core.Ordered接口
 * 2.使用@Order注解指定优先级
 * @Date: Created In 15:53 2018/9/26
 */
public class SpringAopProxy {
/**
 *  Spring提供了两种方式来生成代理对象: JDKProxy和Cglib，具体使用哪种方式生成由AopProxyFactory根据AdvisedSupport对象的配置来决定
 * 1.默认的策略:配置了aop显示优化||目标类没有实现接口||配置了目标类代理配置为true 则Cglib来生成代理，否则使用JDK动态代理技术
 * 2.因为默认没有aop显示优化、目标类代理配置为false
 * 2.如何要使用Cglib代理，需要在application.properties加配置:spring.aop.proxy-target-class=true
 *
 * jdk代理切面如何织入(简述):
 * 1.JdkDynamicAopProxy实现了InvocationHandler，通过invoke方法进行织入
 * 2.获取可以应用到此方法上的通知链（Interceptor Chain，目的是调用该链对应的通知方法）
 * 3.如果有通知链,则应用通知,并执行joinpoint;
 * 4.如果没有通知链,则直接反射执行joinpoint
 *
 * 注:
 *  1.切面是在目标对象被实例化的是时候织入目标对象的
 *  2.更准确的说，切面是在目标对象的bean在完成初始实例化之后bean工厂调用bean的后处理器将切面织入到目标对象中的
 */

/**
 * SpringAop织入：
 * 1. Spring为我们提供了自动代理机制，让容器为我们自动生成代理，把我们从烦琐的配置工作中解放出来，在内部，Spring 使用BeanPostProcessor自动地完成这项工作。
 * 2.这些基于BeanPostProcessor的自动代理创建器的实现类，将根据一些规则自动在容器实例化Bean时为匹配的Bean生成代理实例
 *   2.1）基于Bean配置名规则的自动代理创建器：允许为一组特定配置名的Bean自动创建代理实例的代理创建器，实现类为BeanNameAutoProxyCreator；
 *   2.2）基于Advisor匹配机制的自动代理创建器：它会对容器中所有的Advisor进行扫描，自动将这些切面应用到匹配的Bean中（即为目标Bean创建代理实例），实现类为DefaultAdvisorAutoProxyCreator；
 *   2.3）基于Bean中AspjectJ注解标签的自动代理创建器：为包含AspectJ注解的Bean自动创建代理实例，它的实现类是AnnotationAwareAspectJAutoProxyCreator，该类是Spring 2.0的新增类。
 */
}
