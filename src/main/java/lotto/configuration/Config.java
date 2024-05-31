package lotto.configuration;

import lotto.agent.LottoPrizeGradeHandler;
import lotto.agent.LottoResultHandler;
import lotto.function.InputHandler;
import lotto.function.Validator;
import lotto.function.LottoViewer;
import lotto.agent.LottoWinningNumberDecider;
import lotto.agent.LottoDealer;

public class Config {
    public LottoDealer lottoDealer() {
        return new LottoDealer(inputHandler(), lottoViewer());
    }

    public LottoViewer lottoViewer() {
        return new LottoViewer();
    }

    public Validator validator() {
        return new Validator();
    }

    public LottoWinningNumberDecider lottoWinningNumberDecider() {
        return new LottoWinningNumberDecider(lottoViewer(), inputHandler());

    }
    public InputHandler inputHandler() {
        return new InputHandler(validator());
    }

    public LottoResultHandler lottoResultHandler() {
        return new LottoResultHandler(lottoPrizeGradeHandler());
    }

    public LottoPrizeGradeHandler lottoPrizeGradeHandler() {
        return new LottoPrizeGradeHandler();
    }
}
