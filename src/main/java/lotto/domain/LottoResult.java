package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {
    private final LinkedHashMap<LottoPrizeGrade, Integer> winnerMap;
    private final int numberLottoTicket;

    public LottoResult(LinkedHashMap<LottoPrizeGrade, Integer> winnerMap,
                       List<Lotto> buyLottoTickets) {
        this.winnerMap = winnerMap;
        this.numberLottoTicket = buyLottoTickets.size();
    }

    private double getBenefitRate() {
        int totalWinningPrize = 0;
        for (LottoPrizeGrade grade :  winnerMap.keySet()) {
            totalWinningPrize += grade.getPrizeMoney() * winnerMap.get(grade);
        }
        return (double) totalWinningPrize / (numberLottoTicket * 1000) * 100;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        StringBuilder sb = new StringBuilder();
        for (LottoPrizeGrade grade : winnerMap.keySet()) {
            sb.append(grade.getWinString());
            sb.append(" (").append(formatter.format(grade.getPrizeMoney())).append("원) - ");
            sb.append(winnerMap.get(grade)).append("개").append("\n");
        }
        sb.append("총 수익률은 ");
        sb.append(Math.round(getBenefitRate() * 100) / 100.0);
        sb.append("%입니다.\n");
        return sb.toString();
    }
}
