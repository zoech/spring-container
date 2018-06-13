package com.imeee.configuration;

import com.imeee.factorybean.MyFactoryBean;
import com.imeee.model.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * @author eee
 * Date: 2018-06-13
 * Time: 19:13
 */
@Configuration
public class CustomBeanCfg implements BeanDefinitionRegistryPostProcessor {
    @Autowired
    BeanNameGenerator beanNameGenerator;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(MyFactoryBean.class);
        beanDefinition.setLazyInit(true);
        beanDefinition.getPropertyValues().addPropertyValue("clz", MyBean.class);
        String beanName = "testBean";//this.beanNameGenerator.generateBeanName(beanDefinition, beanDefinitionRegistry);
        beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
