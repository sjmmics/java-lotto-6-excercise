package lotto.agent;

import lotto.function.InputValidator;
import lotto.function.LottoViewer;
import lotto.domain.Lotto;

public class LottoWinningNumberDecider {
    private final LottoViewer viewer;
    private final InputValidator inputValidator;

    public LottoWinningNumberDecider(LottoViewer viewer,
                                     InputValidator inputValidator) {
        this.viewer = viewer;
        this.inputValidator = inputValidator;
    }

    public Lotto setWinningLottoNumber() {
        viewer.enterWinningLottoNumber();
        return new Lotto(inputValidator.setProperLottoInput());
    }

    public int setBonusLottoNumber(Lotto winLotto) {
        viewer.enterBonusNumber();
        return inputValidator.setBonusLottoNumber(winLotto);
    }
}
