package lotto.function;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputHandler {
    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    private final Validator validator;

    public int setMoneyToBuyLotto() {
        while (true) {
            try {
                String inputMoneyString = Console.readLine();
                validator.validateAllDigit(inputMoneyString);
                validator.validateModZero(inputMoneyString);
                return Integer.parseInt(inputMoneyString);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> setLottoInput() {
        while (true) {
            try {
                String inputString = Console.readLine();
                validator.validateAllDigitOrComma(inputString);
                List<Integer> inputList = changeStringInputToList(inputString);
                validator.validateDigitLottoNumber(inputList);
                validator.validateDuplicateNumberInLotto(inputList);
                validator.validateAllNumberInRightRange(inputList);
                return inputList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Integer> changeStringInputToList(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, ",");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        return list;
    }

    public int setBonusLottoNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                String inputBonusNumberString = Console.readLine();
                validator.validateAllDigit(inputBonusNumberString);
                int bonusNumber =
                        Integer.parseInt(inputBonusNumberString);
                validator.validateNumberInRange(bonusNumber);
                validator.validateDuplicateWinLottoAndBonusNumber(bonusNumber, winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
