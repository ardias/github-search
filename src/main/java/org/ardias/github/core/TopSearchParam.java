package org.ardias.github.core;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public enum TopSearchParam {
    TOP5("5"),
    TOP10("10"),
    TOP50("50");

    private String val;

    TopSearchParam(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
