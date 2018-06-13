package com.imeee.factorybean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import java.lang.reflect.Constructor;

/**
 * @author eee
 * Date: 2018-06-13
 * Time: 18:56
 */

@Data
public class MyFactoryBean<T> implements FactoryBean<T> {
    Class<T> clz;

    @Nullable
    @Override
    public T getObject() throws Exception {
//        Constructor<T> tC = this.clz.getConstructor();
//        return tC.newInstance();
        return this.clz.newInstance();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return clz;
    }
}
