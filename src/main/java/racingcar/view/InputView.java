package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InputView {
  private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

  public List<String> readCarNames() {
    System.out.println(INPUT_PROMPT);
    String line = Console.readLine();

    List<String> CarNames = parseNames(line);
    validateNames(CarNames);

    return CarNames;
  }

  public int readAttemptCount() {
    System.out.println(COUNT_PROMPT);
    String line = Console.readLine();

    int count = parseAttemptCount(line);
    validateAttemptCount(count);

    return count;
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

  static int parseAttemptCount(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값이 없습니다.");
    }

    String trimmed = input.trim();
    if (trimmed.isEmpty()) {
      throw new IllegalArgumentException("입력이 없습니다. 시도 횟수를 입력하세요.");
    }

    if (!trimmed.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("시도 횟수는 정수여야 합니다. 다른 문자가 혼합되면 안됩니다.");
    }

    // 오버플로우 파싱
    BigInteger value;
    try {
      value = new BigInteger(trimmed);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
    }

    BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
    if (value.compareTo(intMax) > 0) {
      throw new IllegalArgumentException("시도 횟수가 너무 큽니다. 2,147,483,647 이하만 입력 가능합니다..");
    }

    return value.intValue();
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

  static void validateAttemptCount(int count) {
    if (count < 1) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }
}
