package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Racing {
  private final List<Car> cars;

  public Racing(List<String> carNames) {
    this.cars = toCars(carNames);
  }

  public void run(int attempts) {
    for (int i = 0; i < attempts; i++) {
      playOneRound();
    }
  }

  private void playOneRound() {
    for (Car car : cars) {
      int rand = Randoms.pickNumberInRange(0, 9);
      car.move(rand);
    }
  }

  private List<Car> toCars(List<String> names) {
    List<Car> list = new ArrayList<>(names.size());
    for (String n : names) {
      list.add(new Car(n));
    }
    return list;
  }
}
