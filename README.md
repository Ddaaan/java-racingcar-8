# java-racingcar-precourse

## 기능 목록

### 입력 & 검증

- [ ] 자동차 이름 입력받기 (쉼표 구분, 앞뒤 공백 제거)
- [ ] 자동차 이름 길이 1~5자 이내 검증
- [ ] 자동차 이름에 빈 값만 있는 경우 `IllegalArgumentException` 발생
- [ ] 시도 횟수 입력받기
- [ ] 시도 횟수 정수 파싱 실패 시 `IllegalArgumentException` 발생
- [ ] 시도 횟수 오버플로우 (int 범위가 넘을 경우) `IllegalArgumentException` 발생
- [ ] 시도 횟수가 1 미만일 경우 `IllegalArgumentException` 발생

### 게임 진행

- [ ] 0~9 랜덤값 생성 후 4 이상이면 해당 자동차 전진
- [ ] 시도 횟수만큼 라운드 반복

### 출력

- [ ] 각 라운드 종료마다 자동차별 위치 출력
- [ ] 최종 우승자 계산