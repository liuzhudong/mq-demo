/**
 *
 */
package com.jelly.liu.mq.demo.jms.service.exception;


import org.apache.commons.lang3.StringUtils;

/**
 * @author Administrator
 */
public class ParamNullException extends Exception {

    private static final long serialVersionUID = 9200505302541885178L;

    private String msg = "为空";

    public ParamNullException() {
        super();
    }

    public ParamNullException(String msg) {
        new ParamNullException();
        String msgStr = "参数:[" + msg + "]";
        msgStr += this.msg;
        this.setMsg(msgStr);
    }

    public ParamNullException(Class<?> clazz) {
        new ParamNullException();
        String msgStr = "参数:[";
        if (clazz != null) {
            msgStr += clazz.getName();
        }
        msgStr += "]";
        msgStr += this.msg;
        this.setMsg(msgStr);
    }

    public ParamNullException(Class<?> clazz, String msg) {
        new ParamNullException();
        String msgStr = "参数:[";
        if (clazz != null) {
            msgStr += clazz.getName();
        }
        msgStr += "]";
        if (StringUtils.isNotBlank(msg)) {
            msgStr += msg;
        } else {
            msgStr += this.msg;
        }
        this.setMsg(msgStr);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
