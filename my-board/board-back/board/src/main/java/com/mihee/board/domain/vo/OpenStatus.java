package com.mihee.board.domain.vo;

public enum OpenStatus {
    // openpublic / openwriter / openadmin / openwriterandadmin
    OPEN_PUBLIC("OPEN_COMMON"),
    OPEN_ADMIN("OPEN_ADMIN"),
    OPEN_WRITER_AND_ADMIN("OPEN_WRITER_AND_ADMIN"),
    OPEN_WRITER("OPEN_WRITER")
    ;
    private String value;

    OpenStatus(String value) {
        this.value = value;
    }

    public static OpenStatus findOpenStatus(String values) {
        for (OpenStatus value: OpenStatus.values()) {
            if (values.equals(value)){
                return value;
            }
        }
        throw new RuntimeException();
    }


}
