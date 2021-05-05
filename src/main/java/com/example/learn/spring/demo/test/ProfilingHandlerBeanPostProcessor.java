package com.example.learn.spring.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        if(clazz.isAnnotationPresent(Profiling.class)){
            map.put(beanName,clazz);
        }
        return bean;
    }

    public ProfilingHandlerBeanPostProcessor() {
      MBeanServer mBeanServer =  ManagementFactory.getPlatformMBeanServer();
        try {
            mBeanServer.registerMBean(controller,new ObjectName("profiling","name","controller"));
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(controller.isEnabled()){
                    System.out.println("Profiling ....");
                    Object retval = method.invoke(bean,args);
                    System.out.println("all");
                    return retval;
                    }else{
                        return method.invoke(bean,args);
                    }
                }
            });
        }
        return bean;
    }
}
