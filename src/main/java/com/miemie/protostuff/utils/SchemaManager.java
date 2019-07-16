package com.miemie.protostuff.utils;

import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SchemaManager {
    public static <T> Schema<T> getSchema(Class<T> clazz){
        Map<Class<?>, Schema<?>> schemaCache  = new ConcurrentHashMap<Class<?>, Schema<?>>();
        Schema<T> schema = (Schema<T>) schemaCache.get(clazz);
        if(Objects.isNull(schema)){
            /*这个schema通过RuntimeSchema进行懒创建并缓存
              所以可以一直调用RuntimeSchema.getSchema(),这个方法是线程安全的
            */
            schema = RuntimeSchema.getSchema(clazz);
            if(Objects.nonNull(schema)){
                schemaCache.put(clazz, schema);
            }
        }
        return schema;
    }
}
