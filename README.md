# study-idleworld-coupon

### week3
운영자가 원하는 쿠폰 수량대로 쿠폰을 발급하는 기능을 구현한다
1. batch로 쿠폰을 generate한다. 자체 제작 쿠폰, 타 제휴서비스에 발급 요청을 하는 기능으로 나뉜다. 
2. 발급된 쿠폰을 mongodb에 저장한다. mongo를 사용한 이유는 다음과 같다.
   1. 사실 최적의 솔루션은 현재 Redis로 보이지만, 전시서버를 위해 mongo 고민이 필요하다.
   2. 다양한 쿠폰 종류, 제휴처등의 상황을 고려해 flexible schema 지원이 필요하다 가정했다.