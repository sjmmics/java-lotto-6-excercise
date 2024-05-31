package lotto.domain;

import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;

    private Integer bonusNumber;

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
