package lotto.function;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.*;

public class InputValidator {

    public int setProperInputMoneyToBuyLotto() {

        while (true) {
            try {
                String inputMoneyString = Console.readLine();
                isAllDigit(inputMoneyString);
                isModZero(inputMoneyString);
                return Integer.parseInt(inputMoneyString);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isModZero(String inputMoneyString) {
        int inputMoneyIntValue = Integer.parseInt(inputMoneyString);
        if (inputMoneyIntValue % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] " +
                    "1,000으로 나누어 떨어지는 숫자를 입력하세요. ");
        }
    }

    private void isAllDigit(String inputMoneyString) {
        for (int i = 0; i < inputMoneyString.length(); i++) {
            if (!Character.isDigit(inputMoneyString.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] " +
                        "숫자를 입력하세요. ");
            }
        }
    }

    public List<Integer> setProperLottoInput() {
        while (true) {
            try {
                String inputString = Console.readLine();
                validateAllDigitOrComma(inputString);
                List<Integer> inputList = changeStringInputToList(inputString);
                validateDigitLottoNumber(inputList);
                validateDuplicateNumberInLotto(inputList);
                validateAllNumberInRightRange(inputList);
                return inputList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateAllDigitOrComma(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (!Character.isDigit(c) && c != ',') {
                throw new IllegalArgumentException("[ERROR] 숫자와 " +
                        "콤마(,)만 붙여서 입력하세요.");
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

    private void validateDigitLottoNumber(List<Integer> inputList) {
        if (inputList.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " +
                    "숫자를 6개 입력하세요.");
        }
    }

    private void validateDuplicateNumberInLotto(List<Integer> inputList) {
        HashSet<Integer> set = new HashSet<>(inputList);
        if (inputList.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] " +
                    "중복된 숫자를 입력하지 마세요.");
        }
    }

    private void validateAllNumberInRightRange(List<Integer> inputList) {
        for (int num : inputList) {
            if (1 > num || 45 < num) {
                throw new IllegalArgumentException("[ERROR] " +
                        "1 ~ 45 사이의 자연수만 입력하세요.");
            }
        }
    }

    public int setBonusLottoNumber(Lotto winLotto) {
        while (true) {
            try {
                String inputBonusNumberString = Console.readLine();
                isAllDigit(inputBonusNumberString);
                int bonusNumber =
                        Integer.parseInt(inputBonusNumberString);
                isNumberInRange(bonusNumber);
                isDuplicateWinLottoAndBonusNumber(bonusNumber, winLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isDuplicateWinLottoAndBonusNumber(int bonusNumber,
                                                   Lotto winLotto) {
        List<Integer> winLottoNumbers = winLotto.getNumbers();
        for (int number : winLottoNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] " +
                        "당첨 번호와 중복되는 보너스 번호를 입력하지 마세요.");
            }
        }

    }

    private void isNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] " +
                    "1 ~ 45 사이의 숫자를 입력하세요.");
        }
    }

}
