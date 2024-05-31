package lotto.agent;

import lotto.domain.Lotto;
import lotto.domain.LottoPrizeGrade;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResultHandler {

    private final LottoPrizeGradeHandler gradeHandler;

    public LottoResultHandler(LottoPrizeGradeHandler gradeHandler) {
        this.gradeHandler = gradeHandler;
    }

    public LottoResult setLottoResult(List<Lotto> buyLottoTickets,
                                      WinningLotto winningLotto) {

        gradeHandler.setGradeLottoTickets(buyLottoTickets, winningLotto);
        LinkedHashMap<LottoPrizeGrade, Integer> winnerCountMap = getWinnerLottoCountMap(buyLottoTickets);
        return new LottoResult(winnerCountMap, buyLottoTickets);
    }

    private LinkedHashMap<LottoPrizeGrade, Integer> getWinnerLottoCountMap(List<Lotto> buyLottoTickets) {
        LinkedHashMap<LottoPrizeGrade, Integer> winnerCountMap = new LinkedHashMap<>();
        initMap(winnerCountMap);
        for (Lotto lotto : buyLottoTickets) {
            if (lotto.getGrade().equals(LottoPrizeGrade.WIN_GRADE_NOTING)) {
                continue;
            }
            winnerCountMap.put(lotto.getGrade(), winnerCountMap.get(lotto.getGrade()) + 1);
        }
        return winnerCountMap;
    }

    private void initMap(HashMap<LottoPrizeGrade, Integer> winnerCountMap) {
        winnerCountMap.put(LottoPrizeGrade.WIN_GRADE_5TH, 0);
        winnerCountMap.put(LottoPrizeGrade.WIN_GRADE_4TH, 0);
        winnerCountMap.put(LottoPrizeGrade.WIN_GRADE_3RD, 0);
        winnerCountMap.put(LottoPrizeGrade.WIN_GRADE_2ND, 0);
        winnerCountMap.put(LottoPrizeGrade.WIN_GRADE_1ST, 0);
    }

}
