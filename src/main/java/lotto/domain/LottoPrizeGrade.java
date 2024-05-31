package lotto.domain;

public enum LottoPrizeGrade {
    WIN_GRADE_NOTING(0, ""),
    WIN_GRADE_5TH(5_000, "3개 일치"),
    WIN_GRADE_4TH(50_000, "4개 일치"),
    WIN_GRADE_3RD(1_500_000, "5개 일치"),
    WIN_GRADE_2ND(30_000_000, "5개 일치, 보너스 볼 일치"),
    WIN_GRADE_1ST(2_000_000_000, "6개 일치");
    final int prizeMoney;
    final String winString;

    LottoPrizeGrade(int prizeMoney, String winString) {
        this.prizeMoney = prizeMoney;
        this.winString = winString;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinString() {
        return winString;
    }
}
