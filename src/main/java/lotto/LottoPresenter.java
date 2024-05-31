package lotto;

import lotto.agent.LottoDealer;
import lotto.agent.LottoResultHandler;
import lotto.agent.LottoWinningNumberDecider;
import lotto.configuration.Config;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.function.LottoViewer;

import java.util.List;

public class LottoPresenter {
    private static LottoDealer lottoDealer;
    private static LottoViewer viewer;
    private static LottoWinningNumberDecider lottoWinningNumberDecider;
    private static LottoResultHandler resultHandler;
    public void run() {
        setConfig();
        int numberBuyLotto = lottoDealer.setNumberBuyToLottoTicket();
        List<Lotto> buyLottoTickets = lottoDealer.setBuyLottoTickets(numberBuyLotto);
        WinningLotto winningLotto = lottoWinningNumberDecider.setWinningLotto();
        LottoResult result = resultHandler.setLottoResult(buyLottoTickets, winningLotto);
        viewer.showResult(result);
    }

    private void setConfig() {
        Config config = new Config();
        viewer = config.lottoViewer();
        lottoDealer = config.lottoDealer();
        lottoWinningNumberDecider = config.lottoWinningNumberDecider();
        resultHandler = config.lottoResultHandler();
    }

}
