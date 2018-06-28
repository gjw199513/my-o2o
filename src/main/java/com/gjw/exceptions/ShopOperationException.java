package com.gjw.exceptions;

import org.apache.ibatis.javassist.SerialVersionUID;

/**
 * Created by gjw19 on 2018/6/24.
 */
public class ShopOperationException extends RuntimeException {

    public ShopOperationException(String msg){
        super(msg);
    }
}
