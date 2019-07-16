package com.miemie.protostuff;

import com.miemie.protostuff.deserialize.Deserialize;
import com.miemie.protostuff.model.Group;
import com.miemie.protostuff.model.User;
import com.miemie.protostuff.serialize.Serialize;

import java.util.Arrays;

public class AdminTest {
    public static void main(String[] args) {

        Group group = new Group();
        group.setId("1");
        group.setAge(20);
        group.setName("张三");
        group.setDesc("programmer");
        //创建一个Group对象
        User user = new User();
        user.setId("1");
        user.setName("分组1");
        //使用ProtostuffUtils序列化
        byte[] data = Serialize.serialize(group);
        System.out.println("序列化后：" + Arrays.toString(data));
        Group result = Deserialize.deserialize(data, Group.class);
        System.out.println("反序列化后：" + result.toString());
    }



}
