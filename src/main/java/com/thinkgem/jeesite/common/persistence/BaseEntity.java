/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.thinkgem.jeesite.common.persistence;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.MappedSuperclass;

/**
 * Entity支持类
 * @author ThinkGem
 * @version 2013-01-15
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// 删除标记（0：正常；1：删除）
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";

	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";
	
	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";

	// 状态状态（0：发布；1：作废；2：审核；）
	public static final String STATUS_RELEASE = "0";
	public static final String STATUS_DELETE = "1";
	public static final String STATUS_AUDIT = "2";

	@Override
	 public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // 获取Bean的所有方法
        Method[] methods = this.getClass().getMethods();

        // 方法名
        String methodName = null;
        String fieldName = null;

        try {
            
            // 遍历，取Getter方法
            for (Method method : methods) {
                methodName = method.getName();

                if (methodName.startsWith("get")) {

                    if ("getClass".equals(methodName)) {
                        continue;
                    }

                    fieldName = methodName.substring(3);
                    fieldName = fieldName.substring(0, 1).toLowerCase()
                            + fieldName.substring(1);
                    
                    sb.append(fieldName + "=[" + method.invoke(this, null) + "] ");
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        sb.append("]");
        return sb.toString();
    }
}
