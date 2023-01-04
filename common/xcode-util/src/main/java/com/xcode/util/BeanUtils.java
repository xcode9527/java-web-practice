package com.xcode.util;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.core.Converter;
import org.springframework.objenesis.ObjenesisStd;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhoudawei
 * @Date 2023/1/3 16:08
 * @Version 1.0
 */
public class BeanUtils {

    private BeanUtils() {
    }

    private static ThreadLocal<ObjenesisStd> OBJENESISSTD_THREADLOCAL = ThreadLocal.withInitial(ObjenesisStd::new);
    private static ConcurrentHashMap<Class<?>, ConcurrentHashMap<Class<?>, BeanCopier>> CACHE = new ConcurrentHashMap<>();

    public static <T> T copy(Object source, Class<T> target) {
        if (Objects.isNull(source)) {
            return null;
        }
        return copy(source, OBJENESISSTD_THREADLOCAL.get().newInstance(target));
    }

    public static <T> T copy(Object source, T target) {
        BeanCopier beanCopier = getCacheBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
        return target;
    }

    public static <T> List<T> copyList(List<?> sources, Class<T> target) {
        if (sources.isEmpty()) {
            return Collections.emptyList();
        }

        ArrayList<T> list = new ArrayList<>(sources.size());
        ObjenesisStd objenesisStd = OBJENESISSTD_THREADLOCAL.get();
        for (Object source : sources) {
            if (source == null) {
                throw new RuntimeException("empty source object");
            }
            T newInstance = objenesisStd.newInstance(target);
            BeanCopier beanCopier = getCacheBeanCopier(source.getClass(), target);
            beanCopier.copy(source, newInstance, null);
            list.add(newInstance);
        }
        return list;
    }

    public static <T> List<T> copyList(List<?> sources, Class<T> target, Converter converter) {
        return null;
    }

    public static <T> T mapToBean(Map<?, ?> source, Class<T> target) {
        T bean = OBJENESISSTD_THREADLOCAL.get().newInstance(target);
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(source);
        return bean;
    }

    public static <T> Map<?, ?> beanToMap(T source) {
        return BeanMap.create(source);
    }

    private static <S, T> BeanCopier getCacheBeanCopier(Class<S> source, Class<T> target) {
        ConcurrentHashMap<Class<?>, BeanCopier> copierConcurrentHashMap = CACHE.computeIfAbsent(source, aClass -> new ConcurrentHashMap<>(16));
        return copierConcurrentHashMap.computeIfAbsent(target, aClass -> BeanCopier.create(source, target, false));
    }

    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        copyList(lists, Object.class, (a, b, c) -> {
            return null;
        });
    }

}
