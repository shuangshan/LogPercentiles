package com.css;

import java.util.function.Function;

/**
 * @author shuangshan
 * @create 2019-07-0714:01
 * @email 13690578@qq.com
 * @description catch exception for non-exception catch functions.
 */
@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

    @Override
    public default R apply(T t) {
        try {
            return throwingApply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, R> Function<T, R> wrap(ThrowingFunction<T, R> f) {
        return f;
    }

    R throwingApply(T t) throws Exception;
}
