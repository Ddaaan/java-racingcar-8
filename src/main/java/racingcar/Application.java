package racingcar;

import java.util.List;
import racingcar.view.InputView;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    InputView inputView = new InputView();
    List<String> carNames = inputView.readCarNames();
  }
}
