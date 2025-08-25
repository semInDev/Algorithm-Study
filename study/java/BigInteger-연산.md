# long을 벗어나는 큰 수를 다룰 때, BigInteger
코테 풀 때, <br>
변수 범위가 ',(콤마)' 3개를 넘어가면 long을 사용하고<br>
변수 범위가 ',(콤마)' 6개를 넘어가면 BigInteger을 사용하는 것이 안전하다.<br>

## BigInteger 선언부
```java
import java.math.BigInteger;

BigInteger n = new BigInteger("100000");
BigInteger n = new BigInteger.valueOf(100000);
```

## BigInteger 캐스팅
```java
int intN = n.intValue();
long longN = n.longValue();
```

## BigInteger 사칙연산
```java
BigInteger a = new BigInteger("100");
BigInteger b = new BigInteger("10");

a.add(b);
a.subtract(b);
a.multiply(b);
a.divide(b);
a.remainder(b); // %
```

## BigInteger 비교연산
```java
BigInteger a = new BigInteger("100");
BigInteger b = new BigInteger("10");

a.compareTo(b) // 1, 0, -1로 결과 리턴
```

