package lotto;

import java.util.List;

public class LottoViewer {

    public void enterMoneyToSpend() {
        System.out.println("구매 금액을 입력해 주세요.");
    }

    public void resultBuyLottoTickets(List<Lotto> buyLottoTickets) {
        System.out.println(buyLottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : buyLottoTickets) {
            System.out.println(lotto);
        }
    }

    public void enterWinLottoNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void showResult(LottoWinResult result) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
        System.out.println("총 수익률은 " + result.getTotalBenefitRate() +
                "%입니다.");
    }
}
