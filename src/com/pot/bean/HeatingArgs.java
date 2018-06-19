package com.pot.bean;

public class HeatingArgs {
    private long time;
    private int pre;
    private int temp;

    public HeatingArgs() {

    }

    public HeatingArgs(long time, int pre, int temp) {
        this.time = time;
        this.pre = pre;
        this.temp = temp;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public long getTime() {
        return time;
    }

    public int getPre() {
        return pre;
    }

    public int getTemp() {
        return temp;
    }
}
