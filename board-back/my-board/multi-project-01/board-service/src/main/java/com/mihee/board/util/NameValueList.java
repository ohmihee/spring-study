package com.mihee.board.util;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class NameValueList implements JsonSerializable{
    private List<NameValue> nameValues;

    public NameValueList() {this.nameValues = new ArrayList<>();}
    public NameValueList(NameValue nameValue) {
        this();
        this.nameValues.add(nameValue);
    }
    public NameValueList(String name, String value) {
        this();
        this.nameValues.add(new NameValue(name, value));
    }

    public NameValueList(NameValueList nameValues) {
        this();
        //this.nameValues.addAll(nameValues.list())
    }
}
