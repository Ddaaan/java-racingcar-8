package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
  private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

  public List<String> readCarNames() {
    System.out.println(INPUT_PROMPT);
    String link = Console.readLine();

    List<String> CarNames = parseNames(link);

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
}
