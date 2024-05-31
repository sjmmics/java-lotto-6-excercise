package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private LottoPrizeGrade grade;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setGrade(LottoPrizeGrade grade) {
        this.grade = grade;
    }

    public LottoPrizeGrade getGrade() {
        return grade;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException("[ERROR] " +
                    "로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
