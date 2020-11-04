package com.ruoyi.common.core.controller;

import java.io.Serializable;
import java.util.List;

public class BaseDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<?> list;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
