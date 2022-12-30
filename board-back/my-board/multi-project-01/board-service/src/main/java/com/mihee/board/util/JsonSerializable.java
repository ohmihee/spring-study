package com.mihee.board.util;

public interface JsonSerializable {
    default String toJson () {return JsonUtil.toJson(this);}
    default String toPrettyJson() {
        return JsonUtil.toPrettyJson(this);
    }
}
