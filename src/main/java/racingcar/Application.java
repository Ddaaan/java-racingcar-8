package racingcar;

import java.util.List;
import racingcar.game.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
  public static void main(String[] args) {
    InputView input = new InputView();
    List<String> names = input.readCarNames();
    int attempts = input.readAttemptCount();

    new Racing(names, new ResultView()).run(attempts);
  }
}
