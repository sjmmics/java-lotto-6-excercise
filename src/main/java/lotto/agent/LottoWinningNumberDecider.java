package lotto.agent;

import lotto.domain.WinningLotto;
import lotto.function.InputHandler;
import lotto.function.LottoViewer;

import java.util.List;

public class LottoWinningNumberDecider {
    private final LottoViewer viewer;
    private final InputHandler inputHandler;

    public LottoWinningNumberDecider(LottoViewer viewer,
                                     InputHandler inputHandler) {
        this.viewer = viewer;
        this.inputHandler = inputHandler;
    }

    public WinningLotto setWinningLotto() {
        viewer.enterWinningLottoNumber();
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningLottoMainNumber = inputHandler.setLottoInput();
        winningLotto.setNumbers(winningLottoMainNumber);
        viewer.enterBonusNumber();
        Integer bonusNumber = inputHandler.setBonusLottoNumber(winningLotto);
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }
}
