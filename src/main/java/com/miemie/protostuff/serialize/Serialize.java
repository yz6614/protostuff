package com.miemie.protostuff.serialize;

import com.miemie.protostuff.utils.SchemaManager;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;

public class Serialize {
    private static LinkedBuffer buffer =  LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    public static <T> byte[] serialize(T object){
        Class<T> clazz  = (Class<T>) object.getClass();
        Schema<T> schema = SchemaManager.getSchema(clazz);
        byte[] data;
        try{
            data = ProtostuffIOUtil.toByteArray(object,schema, buffer);
        }finally{
            buffer.clear();
        }

        return data;
    }
}
