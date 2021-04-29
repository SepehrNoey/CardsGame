package hw4_q3;

public enum cards_type_enum {
    CARD_2,
    CARD_3,
    CARD_4,
    CARD_5,
    CARD_6,
    CARD_7,
    CARD_7_YE,
    CARD_8,
    CARD_9,
    CARD_10,
    CARD_A,
    CARD_B,
    CARD_C,
    CARD_D;

    @Override
    public String toString(){
        switch (this)
        {
            case CARD_2 : return "2";
            case CARD_3 : return "3";
            case CARD_4 : return "4";
            case CARD_5 : return "5";
            case CARD_6 : return "6";
            case CARD_7 :
            case CARD_7_YE: return "7";
            case CARD_8 : return "8";
            case CARD_9 : return "9";
            case CARD_10: return "10";
            case CARD_A : return "A";
            case CARD_B : return "B";
            case CARD_C : return "C";
            case CARD_D : return "D";
            default: return null;
        }
    }
}
