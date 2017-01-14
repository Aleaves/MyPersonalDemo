package com.app.liulongbing.mypersonaldemo;

/**
 * Created by liulongbing on 17/1/14.
 */

public class PersonItem {

    private String title;

    private String desc;

    public PersonItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
