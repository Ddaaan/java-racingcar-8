package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class ResultView {

  public void printStart() {
    System.out.println("실행 결과");
  }

  public void printRound(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
    System.out.println();
  }

  public void printWinners(List<Car> winners) {
    String names = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    System.out.println("최종 우승자 : " + names);
  }
}
