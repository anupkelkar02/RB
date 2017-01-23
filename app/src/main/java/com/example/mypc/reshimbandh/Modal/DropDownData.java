package com.example.mypc.reshimbandh.Modal;

/**
 * Created by my pc on 16-01-2017.
 */

public class DropDownData<s>{
    private String text;
    private s item;
    public DropDownData(String text, s item) {
        this.text = text;
        this.item = item;
    }
    public String getText() {
        return text;
    }
    public s getItem() {
        return item;
    }
    @Override
    public String toString() {
        return getText();
    }
}
