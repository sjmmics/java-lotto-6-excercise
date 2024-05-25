package lotto.configuration;

import lotto.function.InputValidator;
import lotto.function.LottoViewer;
import lotto.agent.LottoWinnerDecider;
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

    public LottoWinnerDecider lottoWinnerDecider() {
        return new LottoWinnerDecider(lottoViewer(), validator());
    }
}
