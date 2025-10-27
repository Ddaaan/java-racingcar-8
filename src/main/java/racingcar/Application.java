package racingcar;

import java.util.List;
import racingcar.game.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    try {
      InputView inputView = new InputView();

      List<String> carNames = inputView.readCarNames();
      int attempts = inputView.readAttemptCount();

      new Racing(carNames, new ResultView()).run(attempts);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
