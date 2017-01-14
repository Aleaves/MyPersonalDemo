package com.app.liulongbing.person;

/**
 * Created by liulongbing on 17/1/14.
 */

public class PersonItem {

    private String title;

    private String desc;

    private Class cls;

    public PersonItem(String title, String desc, Class cls) {
        this.title = title;
        this.desc = desc;
        this.cls = cls;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
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
