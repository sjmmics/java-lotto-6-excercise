package lotto.agent;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.function.InputHandler;
import lotto.domain.Lotto;
import lotto.function.LottoViewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDealer {
    private final InputHandler inputHandler;
    private final LottoViewer viewer;

    public LottoDealer(InputHandler inputHandler, LottoViewer viewer) {
        this.inputHandler = inputHandler;
        this.viewer = viewer;
    }

    public int setNumberBuyToLottoTicket() {
        viewer.enterMoneyToSpend();
        return inputHandler.setMoneyToBuyLotto() / 1_000;
    }

    public List<Lotto> setBuyLottoTickets(int numberBuyLotto) {
        List<Lotto> buyLottoTickets = new ArrayList<>();
        for (int i = 0; i < numberBuyLotto; i++) {
            List<Integer> randomLottoNumberlist =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> toSortList = new ArrayList<>(randomLottoNumberlist);
            Collections.sort(toSortList);
            buyLottoTickets.add(new Lotto(toSortList));
        }
        viewer.resultBuyLottoTickets(buyLottoTickets);
        return buyLottoTickets;
    }
}
