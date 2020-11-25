package laxer;

public enum Tag {
    ERROR,
    // relop
    AS, // =
    EQ, // ==
    LE, // <=
    GE, // >=
    NE, // !=
    LT, // <
    GT, // >
    ADD,

    // Key Words
    IF, // if
    ELSE, // else
    RETURN, // return
    INT, // int

    NUM, // 数字
    ID, // identifiers

    LP, // (
    RP, // )
    LBT, // [
    RBT, // ]
    LBS, // {
    RBS, // }
    SEM; // ;
}