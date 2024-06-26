# 다형성을 활용한 몬스터와 전쟁 게임

## 상속 & 다형성 & 자바 Reflection 기능을 활용한 게임

### 게임 룰

1. 길드원과 파티원을 구성하여 각 스테이지마다 몬스터를 죽이는 게임이다. </br>
2. 로비 스테이지에서는 현재 스테이지의 숫자를 확인할 수 있다. </br>
3. 로비 스테이지에서 전투 스테이지로 이동하면 전투를 시작한다. </br>
4. 전투 시, 각 턴에 파티원들이 공격을 하고 그 후 몬스터들이 파티원들을 공격한다. </br>
3. 전투 시, 각 파티원은 공격, 스킬, 아이템 사용 중 하나 선택  가능하다.</br>
4. 전투 시, 모든 몬스터를 죽이면 경험치와 돈을 획득하고 로비 스테이지로 이동한다.</br>
5. 전투 스테이지마다 몬스터가 랜덤하게 생성되며, 이전 전투 스테이지보다 몬스터 수가 1 증가한다. </br>
4. 전투 중, 파티원이 죽으면 부활이 불가능하다, 새로운 전투 스테이지이여도 살아남은 파티원만 전투가 가능하다.</br>
5. 파티원 모두 죽으면 게임에서 지고 게임이 종료된다.</br>
6. 최대한 높은 스테이지로 올라가는 것이 게임의 목표이다.</br>
7. 정비 스테이지에선 길드 관련 업무와 게임 데이터 저장/로드 옵션이 있다.

### 길드 특성
1. 길드의 초기 자본금은 10000이다.</br>
2. 길드는 용병을 고용/해고 가능하다 (고용 비용: 1000).</br>
3. 길드원 중 최대 3명까지 전투에 참여할 파티원으로 구성할 수 있다.</br>
4. 만약 파티원이 만원일 경우, 현재 파티원 한 명을 다른 길드원과 교체가 가능하다. </br>
5. 상점에서 무기, 방어구, 물약이 구매가 가능하고 길드의 자본금으로 결제를 한다.<br/>
6. 상점에서 구매한 아이템을 판매할 수 있으나 세금이 매겨진다.</br>
7. 무기와 방어구는 장착/탈착이 가능하며, 각각 1개만 장착이 가능하다.</br>
8. 인벤토리에 존재하는 아이템들은 길드원 전원이 공유한다. 다만, 이미 장착하는 아이템은 공유가 불가능하다.</br>


### Hero 특성

> 전사의 특성
- 체력: 200</br>
- 공격력: 30</br>
- 스킬: 없음</br>
</br>

> 마법사의 특성
- 체력: 100</br>
- 공격력: 20</br>
- 스킬: [공격력 강화]</br>
</br>

> 의사의 특성
- 체력: 150</br>
- 공격력: 10</br>
- 치유력: 10</br>
- 스킬: [랜덤한 동료 치료하기]</br>
</br>

### 몬스터 특성

> 유령의 특성
- 체력: 50</br>
- 공격력: 0</br>
- 특징: 공격 시, 상대방을 침묵 시켜, 다음 턴에 공격/스킬 못하게 함.</br>
</br>

> 버섯의 특성
- 체력: 400</br>
- 공격력: 10</br>
- 특징: 없음</br>
</br>

> 오크의 특성
- 체력: 300</br>
- 공격력: 30</br>
- 특징: 공격 시, 50% 확률로 공격력이 2배 혹은 0으로 공격.</br>
</br>

### Unit Class Diagram
<img src="https://github.com/typoscript/polyGame/blob/main/images/class_diagram_unit.jpg" />

</br>

### Item Class Diagram
<img src="https://github.com/typoscript/polyGame/blob/main/images/class_diagram_item.jpg" />

</br>

### Stage Class Diagram
<img src="https://github.com/typoscript/polyGame/blob/main/images/class_diagram_stage.jpg" />

</br>

### Battle FlowChart
<img src="https://github.com/typoscript/polyGame/blob/main/images/flowchart_battle.jpg" />

</br>

### 전투 영상
![a](https://github.com/typoscript/polyGame/blob/main/images/battle.gif)

</br>

### 정비 영상
![a](https://github.com/typoscript/polyGame/blob/main/images/market.gif)
