package lotto.domain;

public enum LottoPrizeGrade {
    WIN_GRADE_NOTING(0, ""),
    WIN_GRADE_5TH(5_000, "3개 일치"),
    WIN_GRADE_4TH(50_000, "4개 일치"),
    WIN_GRADE_3RD(1_500_000, "5개 일치"),
    WIN_GRADE_2ND(30_000_000, "5개 일치, 보너스 볼 일치"),
    WIN_GRADE_1ST(2_000_000_000, "6개 일치");


    final int prizeMoney;
    final String winCondition;

    LottoPrizeGrade(int prizeMoney, String winCondition) {
        this.prizeMoney = prizeMoney;
        this.winCondition = winCondition;
    }

    public static LottoPrizeGrade getLottoPrizeGrade(int countMatchLotto,
                                                     int countMatchBonus) {
        if (countMatchLotto == 6) {
            return LottoPrizeGrade.WIN_GRADE_1ST;
        }
        if (countMatchLotto == 5 && countMatchBonus == 1) {
            return LottoPrizeGrade.WIN_GRADE_2ND;
        }
        if (countMatchLotto == 5) {
            return LottoPrizeGrade.WIN_GRADE_3RD;
        }
        if (countMatchLotto == 4) {
            return LottoPrizeGrade.WIN_GRADE_4TH;
        }
        if (countMatchLotto == 3) {
            return LottoPrizeGrade.WIN_GRADE_5TH;
        }
        return LottoPrizeGrade.WIN_GRADE_NOTING;
    }
    public static LottoPrizeGrade prizeGradeEnumGetByIndex(int index) {
        LottoPrizeGrade[] grades = LottoPrizeGrade.values();
        return grades[index];
    }
}
