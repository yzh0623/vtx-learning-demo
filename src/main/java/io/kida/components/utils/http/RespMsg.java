package io.kida.components.utils.http;

public class RespMsg {

    private Integer retcode;

    private String retmsg;

    private Object retdata;

    public RespMsg(Integer retcode) {
        this.retcode = retcode;
    }

    public RespMsg(Integer retcode, Object retdata) {
        this.retcode = retcode;
        this.retdata = retdata;
    }

    public RespMsg(Integer retcode, String retmsg) {
        this.retcode = retcode;
        this.retmsg = retmsg;
    }

    public RespMsg(Integer retcode, Object retdata, String retmsg) {
        this.retcode = retcode;
        this.retmsg = retmsg;
        this.retdata = retdata;
    }

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public Object getRetdata() {
        return retdata;
    }

    public void setRetdata(Object retdata) {
        this.retdata = retdata;
    }

}
