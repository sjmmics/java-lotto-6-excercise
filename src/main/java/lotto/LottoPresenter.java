package lotto;

import java.util.List;

public class LottoPresenter {
    private static LottoDealer lottoDealer;
    private static LottoViewer viewer;
    private static LottoWinnerDecider lottoWinnerDecider;
    public void run() {
        setConfig();
        int numberBuyLotto = lottoDealer.setNumberBuyLotto();
        List<Lotto> buyLottoTickets = lottoDealer.setBuyLottoTickets(numberBuyLotto);
        Lotto winnerLotto = lottoWinnerDecider.setWinnerLotto();
        int bonusLottoNumber = lottoWinnerDecider.setBonusLottoNumber(winnerLotto);
        LottoWinResult result =
                new LottoWinResult(winnerLotto, buyLottoTickets, bonusLottoNumber);
        viewer.showResult(result);
    }

    private void setConfig() {
        Config config = new Config();
        viewer = config.lottoViewer();
        lottoDealer = config.lottoDealer();
        lottoWinnerDecider = config.lottoWinnerDecider();
    }


}
