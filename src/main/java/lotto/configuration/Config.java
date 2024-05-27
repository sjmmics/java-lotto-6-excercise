package lotto.configuration;

import lotto.function.InputValidator;
import lotto.function.LottoViewer;
import lotto.agent.LottoWinningNumberDecider;
import lotto.agent.LottoDealer;

public class Config {
    public LottoDealer lottoDealer() {
        return new LottoDealer(validator(), lottoViewer());
    }

    public LottoViewer lottoViewer() {
        return new LottoViewer();
    }

    public InputValidator validator() {
        return new InputValidator();
    }

    public LottoWinningNumberDecider lottoWinningNumberDecider() {
        return new LottoWinningNumberDecider(lottoViewer(), validator());
    }
}
