### Run axon server firstly

You need the Axon server to run this application.
You can download the Axon server from below url:
https://axoniq.io/download  


<<<<<<< HEAD
## My changes

=======
>>>>>>> f17a1f0 (commit msg)
```

cd axon-server
java -jar axonserver-4.3.5.jar
```

axon server UI  
http://localhost:8024  

or You can run the axon server with docker:

```
docker run -d --name my-axon-server -p 8024:8024 -p 8124:8124 axoniq/axonserver
```

---
--

### 실행시 주의점.  
1. 템플릿 엔진으로 만들어진 파일로는 정상적으로 실행이 안됩니다.  
Aggregate 파일에서 Create 하는 Command 를 꼭 생성자로 커맨드를 발행하여 주세요.  

!! 업데이트,DELETE 쪽은 생성자로 하시면 에러가 발생함  

````java
@CommandHandler
public OrderAggregate(OrderPlacedCommand command){
    OrderPlacedEvent orderPlaced = new OrderPlacedEvent();
    orderPlaced.setId(command.getId());
    AggregateLifecycle.apply(orderPlaced);
}
````

2. controller 에서 command 를 구현하여 주어야 합니다.  

3. axon 서버는 ID 값을 기준으로 이벤트를 소싱 하기 때문에 아래와 같은 에러가 발생시 ID 값을 중복으로 POST 한 것은 아닌지 확인해 보시길 바랍니다.   

```
CommandExecutionException(OUT_OF_RANGE: [AXONIQ-2000] Invalid sequence number 0 for aggregate 2, expected 1)
```

