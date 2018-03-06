package com.my.color.base.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 获取spring bean的工具
 * @author ckl
 *
 */
public class SpringBeanLoader implements BeanFactoryAware{
	
	private static BeanFactory beanFactory = null;
	
	private static SpringBeanLoader springBeanLoader = null;

	@SuppressWarnings("static-access")
	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.beanFactory = factory;
	}
	
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    public static SpringBeanLoader getInstance() {
        if (springBeanLoader == null)
        	springBeanLoader = (SpringBeanLoader) beanFactory.getBean("springBeanLoader");
        return springBeanLoader;
    }
    
    /**
     * 根据提供的bean名称得到相应的服务类     
     * @param servName bean名称     
     */
     public static Object getService(String servName) {
         return beanFactory.getBean(servName);
     }
  
     /**
     * 根据提供的bean名称得到对应于指定类型的服务类
     * @param servName bean名称
     * @param clazz 返回的bean类型,若类型不匹配,将抛出异常
     */
     public static <T> T getService(String servName, Class<T> clazz) {
         try {
			return beanFactory.getBean(servName, clazz);
		} catch (BeansException e) {
			return null;
		}
     }

}
