package lotto;

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
