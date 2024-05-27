package lotto;

import lotto.agent.LottoDealer;
import lotto.agent.LottoWinningNumberDecider;
import lotto.configuration.Config;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.function.LottoViewer;

import java.util.List;

public class LottoPresenter {
    private static LottoDealer lottoDealer;
    private static LottoViewer viewer;
    private static LottoWinningNumberDecider lottoWinningNumberDecider;

    public void run() {
        setConfig();
        int numberBuyLotto = lottoDealer.setNumberBuyToLottoTicket();
        List<Lotto> buyLottoTickets = lottoDealer.setBuyLottoTickets(numberBuyLotto);
        Lotto winnerLotto = lottoWinningNumberDecider.setWinningLottoNumber();
        int bonusLottoNumber = lottoWinningNumberDecider.setBonusLottoNumber(winnerLotto);
        LottoResult result =
                new LottoResult(winnerLotto, buyLottoTickets, bonusLottoNumber);
        viewer.showResult(result);
    }

    private void setConfig() {
        Config config = new Config();
        viewer = config.lottoViewer();
        lottoDealer = config.lottoDealer();
        lottoWinningNumberDecider = config.lottoWinningNumberDecider();
    }


}
