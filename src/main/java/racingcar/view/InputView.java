package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
  private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

  public List<String> readCarNames() {
    System.out.println(INPUT_PROMPT);
    String line = Console.readLine();

    List<String> CarNames = parseNames(line);
    validateNames(CarNames);

    return CarNames;
  }

  // 파싱
  static List<String> parseNames(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값이 없습니다");
    }

    String[] tokens = input.split(",");
    List<String> names = new ArrayList<>(tokens.length);

    for (String token : tokens) {
      String deleteSpace = token.trim();
      names.add(deleteSpace);
    }
    return names;
  }

  static void validateNames(List<String> carNames) {
    if (carNames.isEmpty()) {
      throw new IllegalArgumentException(("자동차 이름이 없습니다."));
    }
    for (String name : carNames) {
      if (name.isBlank()) {
        throw new IllegalArgumentException("자동차 이름에 빈 값이 있습니다.");
      }
      if (name.length() > 5) {
        throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 합니다. 자동차 이름 " + name + "이 잘못되었습니다.");
      }
    }
  }
}
