# study-idleworld-coupon

### week3
운영자가 원하는 쿠폰 수량대로 쿠폰을 발급하는 기능을 구현한다
1. batch로 쿠폰을 generate한다. 자체 제작 쿠폰, 타 제휴서비스에 발급 요청을 하는 기능으로 나뉜다. 
2. 발급된 쿠폰을 mongodb에 저장한다. mongo를 사용한 이유는 다음과 같다.
   1. 사실 최적의 솔루션은 현재 Redis로 보이지만, 전시서버를 위해 mongo 고민이 필요하다.
   2. 다양한 쿠폰 종류, 제휴처등의 상황을 고려해 flexible schema 지원이 필요하다 가정했다.

! 금번 과제에서 고려하지 않은 것
1. 쿠폰 재고 관리 방법
2. 쿠폰 운영에 필요한 추가 정보
3. 쿠폰을 실 사용자들에게 지급하는 방법에 대한 고려

### week5
일단 for문으로 운영자가 입력한 쿠폰 개수, 쿠폰 메타정보로 쿠폰을 몽고db에 발급해두었다.
이제 사용자에게 할당하는 부분을 개발하면 되겠다.
할당시에는 
https://jgrammer.tistory.com/m/entry/Redis%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%84%A0%EC%B0%A9%EC%88%9C-%EC%BF%A0%ED%8F%B0-%EB%B0%9C%EA%B8%89-%EC%84%9C%EB%B2%84-%EC%84%A4%EA%B3%84
https://velog.io/@ddhyun93/Kotlin-Spring-Boot-Redis-Distributed-Lock-%ED%99%9C%EC%9A%A9-%EC%84%A0%EC%B0%A9%EC%88%9C-%EC%9D%91%EB%AA%A8-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EA%B0%9C%EB%B0%9C
위 블로그를 참고하려 한다.
레디스를 공부해야한다!

#### redis
1. 분산락 ( distributed lock ) 을 이용해서 선착순 할당이 동시에 처리되지 않고 단 1개만 처리될 수 있도록 한다..


레디스에 쿠폰을 발급하지 않고 mongodb에 발급하는 이유
1. 메모리 이슈 https://engineering.linecorp.com/ko/blog/LINE-integrated-notification-center-from-redis-to-mongodb
