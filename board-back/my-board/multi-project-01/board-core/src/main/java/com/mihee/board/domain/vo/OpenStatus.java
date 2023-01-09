package com.mihee.board.domain.vo;

public enum OpenStatus {
    All("All"),
    OnlyAdmin("OnlyAdmin")
    ;

    private String openStatus;

    OpenStatus (String openStatus) {
        this.openStatus = openStatus;
    };

    public static OpenStatus findOpenStatus(String openStatus){
        for (OpenStatus status : OpenStatus.values()) {
            if (status.equals(openStatus)) {
                return status;
            }
        }
        throw new RuntimeException();
    }
}
