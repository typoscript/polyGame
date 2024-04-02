# 다형성을 활용한 몬스터와 전쟁 게임

## 상속 & 다형성 & 자바 Reflection 기능을 활용한 게임

### 게임 룰

1. 영웅 3명 (전사, 마법사, 의사)은 각 전투 스테이지마다 랜덤하게 소환된 몬스터와 싸운다. </br>
2. 로비 스테이지에서는 현재 스테이지의 숫자를 확인할 수 있다. </br>
3. 로비 스테이지에서 전투 스테이지로 이동하면 전투를 시작한다. </br>
4. 각 턴에 영웅 3명이 랜덤한 몬스터를 공격, 그 후 몬스터들이 랜덤하게 영웅 3명을 공격한다. </br>
3. 각 영웅의 턴에는 공격 혹은 고유 스킬 사용이 가능하다.</br>
4. 전투 시, 모든 몬스터를 죽이면 로비 스테이지로 이동한다.</br>
5. 다음 스페이지에서는 몬스터가 랜덤하게 생성되며, 이전 스테이지보다 몬스터 수가 1 증가한다. </br>
4. 영웅이 죽으면 부활이 불가능하다, 새로운 전투 스테이지이여도 살아남은 영웅만 전투가 가능하다.</br>
5. 영웅 모두 죽으면 게임에서 지고 게임이 종료된다.</br>
6. 최대한 높은 스테이지로 올라가는 것이 게임의 목표이다.</br>

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

### UML Class Diagram
<img src="https://github.com/typoscript/polyGame/blob/main/images/class_diagram.jpg" />

</br>

### 데모 영상
![a](https://github.com/typoscript/polyGame/blob/main/images/demo.gif)
