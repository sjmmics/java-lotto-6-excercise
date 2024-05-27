package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {
    private final LinkedHashMap<LottoPrizeGrade, Integer> winnerMap;
    private final int numberLottoTicket;

    public LottoResult(Lotto winningLotto, List<Lotto> buyLottoList, int bonusLottoNumber) {
        numberLottoTicket = buyLottoList.size();
        winnerMap = new LinkedHashMap<>();
        int[] countWinnerPerPrize = new int[6];
        for (Lotto buyLotto : buyLottoList) {
            int prizeNumber =
                    getPrizeGradeNumber(buyLotto, winningLotto, bonusLottoNumber);
            countWinnerPerPrize[prizeNumber]++;
        }
        for (int i = 1; i < 6; i++) {
            winnerMap.put(LottoPrizeGrade.prizeGradeEnumGetByIndex(i),
                    countWinnerPerPrize[i]);
        }
    }

    private int getPrizeGradeNumber(Lotto buyLotto,
                                    Lotto winningLotto,
                                    int bonusLottoNumber) {
        int countMatchLotto = 0;
        int countMatchBonus = 0;
        for (int num : buyLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(num)) {
                countMatchLotto++;
            }
            if (bonusLottoNumber == num) {
                countMatchBonus++;
            }
        }
        return LottoPrizeGrade.getLottoPrizeGrade(countMatchLotto,
                countMatchBonus).ordinal();
    }


    public double getTotalBenefitRate() {
        int totalPrizeMoney = 0;
        for (LottoPrizeGrade grade : winnerMap.keySet()) {
            totalPrizeMoney += grade.prizeMoney * winnerMap.get(grade);
        }
        double totalBenefitRate = (double) totalPrizeMoney /
                (numberLottoTicket * 1_000) * 100;
        return Math.round(totalBenefitRate * 100) / 100.0;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        StringBuilder sb = new StringBuilder();
        for (LottoPrizeGrade grade : winnerMap.keySet()) {
            sb.append(grade.winCondition);
            sb.append(" (").append(formatter.format(grade.prizeMoney)).append("원) - ");
            sb.append(winnerMap.get(grade)).append("개").append("\n");
        }
        return sb.toString();
    }
}
