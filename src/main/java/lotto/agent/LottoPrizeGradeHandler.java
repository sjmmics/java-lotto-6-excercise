package lotto.agent;

import lotto.domain.Lotto;
import lotto.domain.LottoPrizeGrade;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPrizeGradeHandler {

    public void setGradeLottoTickets(List<Lotto> buyLottoTickets,
                                     WinningLotto winningLotto) {

        for (Lotto lotto : buyLottoTickets) {
            lotto.setGrade(calculatePrizeGrade(lotto, winningLotto));
        }
    }

    private LottoPrizeGrade calculatePrizeGrade(Lotto lotto,
                                                WinningLotto winningLotto) {
        int matchedNumber = getMatchedNumber(lotto, winningLotto);
        boolean matchedBonusNumber = getMatchedBonusNumber(lotto, winningLotto);

        if (matchedNumber == 6) {
            return LottoPrizeGrade.WIN_GRADE_1ST;
        }
        if (matchedNumber == 5 && matchedBonusNumber) {
            return LottoPrizeGrade.WIN_GRADE_2ND;
        }
        if (matchedNumber == 5) {
            return LottoPrizeGrade.WIN_GRADE_3RD;
        }
        if (matchedNumber == 4) {
            return LottoPrizeGrade.WIN_GRADE_4TH;
        }
        if (matchedNumber == 3) {
            return LottoPrizeGrade.WIN_GRADE_5TH;
        }
        return LottoPrizeGrade.WIN_GRADE_NOTING;
    }

    private boolean getMatchedBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        if (lotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    private int getMatchedNumber(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> commonNumbers = new ArrayList<>(lotto.getNumbers());
        commonNumbers.retainAll(winningLotto.getNumbers());
        return commonNumbers.size();
    }
}
