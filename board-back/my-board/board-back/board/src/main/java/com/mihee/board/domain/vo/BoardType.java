package com.mihee.board.domain.vo;

public enum BoardType {
    // 일반 공지 FAQ Q&A
    COMMON("COMMON"),
    NOTICE("NOTICE"),
    FAQ("FAQ"),
    QNA("Q&A")
    ;
    private String value;
    BoardType(String value){
        this.value = value;
    }

    public static BoardType findBoardType(String values) {
        for (BoardType value: BoardType.values()) {
            if(values.equals(value)) {
                return value;
            }
        }
        throw new RuntimeException();
    }
}
// https://medium.com/webeveloper/enum%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-%EC%83%81%EC%88%98%EA%B0%92-%EA%B4%80%EB%A6%AC-a3e3fb73eae1
