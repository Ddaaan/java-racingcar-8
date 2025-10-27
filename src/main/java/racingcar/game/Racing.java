package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.ResultView;

public class Racing {
  private final List<Car> cars;
  private final ResultView view;

  public Racing(List<String> carNames, ResultView view) {
    this.cars = toCars(carNames);
    this.view = view;
  }

  public void run(int attempts) {
    view.printStart();
    for (int i = 0; i < attempts; i++) {
      playOneRound();
      view.printRound(cars);
    }
    view.printWinners(findWinners());
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

  private List<Car> findWinners() {
    int max = getMaxPosition();
    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == max) {
        winners.add(car);
      }
    }

    return winners;
  }

  private int getMaxPosition() {
    int max = 0;
    for (Car car : cars) {
      if (car.getPosition() > max) {
        max = car.getPosition();
      }
    }

    return max;
  }
}
