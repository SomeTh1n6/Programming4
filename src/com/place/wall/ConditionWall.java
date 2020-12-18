package com.place.wall;

public enum ConditionWall {
    SUDDENLY("неожиданно"); // неожиданно (стены раздвинулись)

    private final String conditionWall;

    ConditionWall(String statusSomeone) {
            this.conditionWall = statusSomeone;
        }

    public String getConditionWall() {
        return conditionWall;
    }

}
