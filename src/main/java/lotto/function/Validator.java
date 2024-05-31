package lotto.function;

import lotto.constant.Constant;
import lotto.domain.WinningLotto;

import java.util.*;

public class Validator {

    protected void validateModZero(String inputMoneyString) {
        int inputMoneyIntValue = Integer.parseInt(inputMoneyString);
        if (inputMoneyIntValue % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                    " 1,000으로 나누어 떨어지는 숫자를 입력하세요. ");
        }
    }

    protected void validateAllDigit(String inputMoneyString) {
        for (int i = 0; i < inputMoneyString.length(); i++) {
            if (!Character.isDigit(inputMoneyString.charAt(i))) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                        " 숫자를 입력하세요. ");
            }
        }
    }

    protected void validateAllDigitOrComma(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (!Character.isDigit(c) && c != ',') {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                        " 숫자와 콤마(,)만 붙여서 입력하세요.");
            }
        }

    }

    protected void validateDigitLottoNumber(List<Integer> inputList) {
        if (inputList.size() != 6) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                    " 숫자를 6개 입력하세요.");
        }
    }

    protected void validateDuplicateNumberInLotto(List<Integer> inputList) {
        HashSet<Integer> set = new HashSet<>(inputList);
        if (inputList.size() != set.size()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                    " 중복된 숫자를 입력하지 마세요.");
        }
    }

    protected void validateAllNumberInRightRange(List<Integer> inputList) {
        for (int num : inputList) {
            if (Constant.MIN_LOTTO_NUMBER > num || Constant.MAX_LOTTO_NUMBER < num) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                        " " + Constant.MIN_LOTTO_NUMBER + " ~ " +
                        Constant.MAX_LOTTO_NUMBER + " 사이의 자연수만 입력하세요.");
            }
        }
    }

    protected void validateDuplicateWinLottoAndBonusNumber(int bonusNumber,
                                                           WinningLotto winningLotto) {
        List<Integer> winLottoNumbers = winningLotto.getNumbers();
        for (int number : winLottoNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                        " 당첨 번호와 중복되는 보너스 번호를 입력하지 마세요.");
            }
        }

    }

    protected void validateNumberInRange(int bonusNumber) {
        if (Constant.MIN_LOTTO_NUMBER > bonusNumber ||
                Constant.MAX_LOTTO_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_PREFIX +
                    " " + Constant.MIN_LOTTO_NUMBER + " ~ " +
                    Constant.MAX_LOTTO_NUMBER + " 사이의 자연수만 입력하세요.");
        }
    }

}
