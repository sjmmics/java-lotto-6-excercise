package lotto.agent;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.function.InputValidator;
import lotto.domain.Lotto;
import lotto.function.LottoViewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDealer {
    private final InputValidator inputValidator;
    private final LottoViewer viewer;

    public LottoDealer(InputValidator inputValidator, LottoViewer viewer) {
        this.inputValidator = inputValidator;
        this.viewer = viewer;
    }

    public int setNumberBuyLotto() {
        viewer.enterMoneyToSpend();
        return inputValidator.setProperInputMoneyToBuyLotto() / 1_000;
    }


    public List<Lotto> setBuyLottoTickets(int numberBuyLotto) {
        List<Lotto> buyLottoTickets = new ArrayList<>();
        for (int i = 0; i < numberBuyLotto; i++) {
            List<Integer> randomLottoNumberlist =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> toSortList = new ArrayList<>();
            toSortList.addAll(randomLottoNumberlist);
            Collections.sort(toSortList);
            buyLottoTickets.add(new Lotto(toSortList));
        }
        viewer.resultBuyLottoTickets(buyLottoTickets);
        return buyLottoTickets;
    }
}
