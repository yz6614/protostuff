package com.miemie.protostuff.deserialize;

import com.miemie.protostuff.utils.SchemaManager;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Deserialize {
    private static LinkedBuffer buffer =  LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    public static <T> T deserialize(byte[] data,Class<T> clazz){
        Schema<T> schema = SchemaManager.getSchema(clazz);
        T object = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data ,object, schema);
        return object;
    }


}
