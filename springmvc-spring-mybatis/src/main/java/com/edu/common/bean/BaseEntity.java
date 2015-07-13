package com.edu.common.bean;

import java.io.Serializable;

/**
 * 抽象的实体超类,专门用于继承
 * Created by lc on 2015/6/4.
 */
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6391445021378844473L;

    public abstract Integer getID();

    public abstract void setID(Integer ID);
}
