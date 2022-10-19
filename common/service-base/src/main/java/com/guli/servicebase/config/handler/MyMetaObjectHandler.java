package com.guli.servicebase.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //mp在添加时的操作
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("gmtCreate",new Date(),metaObject);
        setFieldValByName("gmtModified",new Date(),metaObject);
    }
    //mp在修改时的操作
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
