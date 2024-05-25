package lotto.agent;

import lotto.function.InputValidator;
import lotto.function.LottoViewer;
import lotto.domain.Lotto;

public class LottoWinnerDecider {
    private final LottoViewer viewer;
    private final InputValidator inputValidator;

    public LottoWinnerDecider(LottoViewer viewer, InputValidator inputValidator) {
        this.viewer = viewer;
        this.inputValidator = inputValidator;
    }

    public Lotto setWinnerLotto() {
        viewer.enterWinLottoNumber();
        return new Lotto(inputValidator.setProperLottoInput());
    }

    public int setBonusLottoNumber(Lotto winLotto) {
        viewer.enterBonusNumber();
        return inputValidator.setBonusLottoNumber(winLotto);
    }
}
