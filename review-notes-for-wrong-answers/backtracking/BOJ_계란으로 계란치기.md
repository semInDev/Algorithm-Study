### 문제 정보

- **문제 이름 / 번호**: 백준 16987 계란으로 계란치기

---

### 문제 요약

- 손에 든 계란으로 깨지지 않은 계란들 중 하나를 골라 부딪히게 한다. 왼쪽 계란부터 오른쪽 계란까지 같은 과정을 반복하며 “최대로 많이 깨뜨린 계란 수”를 구한다.

---

### 내가 쓴 풀이 접근

- 백트래킹인 걸 알았지만, 구현하기가 어려웠음. 일단 케이스가 반복되는 느낌이 들면 백트래킹임. 그런데, 정확히 어떻게 백트래킹을 구현하면 좋을 지 어려움.(해당 경우는 bt이 중간에 끊김)

---

### 내가 틀린 이유

- 손에 든 계란이 깨져있을 때(curIdx), 손에 든 계란으로 깰 수 있는 다른 계란이 없을 때 depth == N까지 도달하지 못하고 bt가 끊김. ⇒ if문으로 두 케이스의 경우 bt(curIdx+1, cnt)를 추가해줘야함.

---

### 정답 풀이 핵심 아이디어

- 손에 든 계란이 깨져있을 때(curIdx), 손에 든 계란으로 깰 수 있는 다른 계란이 없을 때 depth == N까지 도달하지 못하고 bt가 끊김. ⇒ if문으로 두 케이스의 경우 bt(curIdx+1, cnt)를 추가해줘야함.

---

### 한 줄 요약 (내 것으로 만들기)

👉 “백트래킹 문제**”는**

“트래킹 구조를 그림으로 그리고, 내가 짠 로직이 순회를 모두 정상적으로 진행하는 지 꼼꼼하게 따져볼 것**.**”

---

## 💡 코드 비교 리뷰

### ❌ 내 코드 (틀린 부분)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
static int N, maxCount=0;
static int[] durabilitys, weights;
static boolean[] isCracked;

public static void main(String[] args) throws IOException {
	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

	StringTokenizer st;
	durabilitys = new int[N];
	weights = new int[N];
	isCracked = new boolean[N];
	for(int i=0; i<N; i++) {
		st = new StringTokenizer(br.readLine());
		durabilitys[i] = Integer.parseInt(st.nextToken());
		weights[i] = Integer.parseInt(st.nextToken());
	}

	bt(0,0);

	System.out.println(maxCount);
}

private static void bt(int curIdx, int cnt) {
	maxCount = Math.max(maxCount, cnt);

	if(curIdx == N) {
		return;
	}
	if(!isCracked[curIdx]) {
		for(int i=0; i<N; i++) {
			if(curIdx == i || isCracked[i]) {
				continue;
			}

			durabilitys[i] = durabilitys[i] - weights[curIdx];
			durabilitys[curIdx] = durabilitys[curIdx] - weights[i];

			if(durabilitys[i] <= 0) {
				isCracked[i] = true;
				cnt++;
			}
			if(durabilitys[curIdx] <= 0) {
				isCracked[curIdx] = true;
				cnt++;
			}

			bt(curIdx+1, cnt);

			if(durabilitys[i] <= 0) {
				isCracked[i] = false;
				cnt--;
			}
			if(durabilitys[curIdx] <= 0) {
				isCracked[curIdx] = false;
				cnt--;
			}

			durabilitys[i] = durabilitys[i] + weights[curIdx];
			durabilitys[curIdx] = durabilitys[curIdx] + weights[i];

		}
	}
}

```

---

### ✅ 정답 코드 (핵심 부분)

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxCount=0;
	static int[] durabilitys, weights;
	static boolean[] isCracked;

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
		durabilitys = new int[N];
		weights = new int[N];
		isCracked = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			durabilitys[i] = Integer.parseInt(st.nextToken());
			weights[i] = Integer.parseInt(st.nextToken());
		}
	
		bt(0,0);
	
		System.out.println(maxCount);
	}
	
	private static void bt(int curIdx, int cnt) {
		if(curIdx == N) {
			maxCount = Math.max(maxCount, cnt);
			return;
		}
		if(isCracked[curIdx]) {
			bt(curIdx+1, cnt);
			return;
		}
		if(!isCracked[curIdx]) {
			boolean crackSomthing = false;
			for(int i=0; i<N; i++) {
				if(curIdx == i || isCracked[i]) {
					continue;
				}
				
				crackSomthing = true;
				
				durabilitys[i] = durabilitys[i] - weights[curIdx];
				durabilitys[curIdx] = durabilitys[curIdx] - weights[i];
	
				if(durabilitys[i] <= 0) {
					isCracked[i] = true;
					cnt++;
				}
				if(durabilitys[curIdx] <= 0) {
					isCracked[curIdx] = true;
					cnt++;
				}
	
				bt(curIdx+1, cnt);
	
				if(durabilitys[i] <= 0) {
					isCracked[i] = false;
					cnt--;
				}
				if(durabilitys[curIdx] <= 0) {
					isCracked[curIdx] = false;
					cnt--;
				}
	
				durabilitys[i] = durabilitys[i] + weights[curIdx];
				durabilitys[curIdx] = durabilitys[curIdx] + weights[i];
	
			}
			if(!crackSomthing) bt(curIdx+1, cnt);
		}
	}
}

```
