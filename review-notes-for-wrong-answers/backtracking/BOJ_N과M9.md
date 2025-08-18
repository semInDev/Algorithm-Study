### 문제 정보

- **문제 이름 / 번호**: 백준 15663 N과 M (9)

---

### 문제 요약

- 길이가 N인 수열에서 길이 M의 수열을 만드는 문제.
- 중복된 숫자가 input에 포함될 수 있으며,
    - 같은 조합이 여러 번 나오면 한 번만 출력해야 함.
    - 출력은 **사전 순으로 정렬된 상태**여야 함.

---

### 내가 쓴 풀이 접근

- 숫자를 오름차순 정렬한 뒤, `backtracking(depth, preIdx)`로 탐색.
- 바로 앞 index(preIdx)와 같은 수, 또는 같은 for문 내에서 중복되는 경우는 건너뛰는 방식.

---

### 내가 틀린 이유

- **preIdx 로직의 한계**:
    - 직전 index만 체크하다 보니, M≥3일 때 멀리 떨어진 중복은 처리 불가.
- **중복 제거 로직 오류**:
    - `(i+1 < N && nums[i] == nums[i+1]) continue;` 조건 때문에,
        
        사실상 같은 값이 여러 번 나올 수 있는 경우를 놓쳤음 (예: 9,9 → "9 9" 안 나옴).
        

---

### 정답 풀이 핵심 아이디어

- **방문 여부 관리**: boolean[] visited 로 각 숫자의 사용 여부를 체크.
- **중복 조합 방지**: for문 돌릴 때 `preNum`을 두어, 같은 깊이에서 이미 사용한 숫자는 건너뜀.
- 즉,
    - `visited` → 이미 선택된 index는 다시 선택하지 않게 함.
    - `preNum` → 같은 depth(재귀 호출 한 단계)에서의 중복을 제거.

---

### 한 줄 요약 (내 것으로 만들기)

👉 “**중복 숫자가 있는 순열 문제”는**

“**visited로 사용 여부를 체크하고, preNum으로 같은 depth 내 중복을 방지한다.**”

---

## 💡 코드 비교 리뷰

### ❌ 내 코드 (틀린 부분)

```java
for(int i=0; i<N; i++) {
    if(preIdx == i || (i+1<N && nums[i] == nums[i+1])) continue;
    output[depth] = nums[i];
    backtracking(depth+1, i);
}

```

- preIdx만 체크해서, 같은 값이 떨어져 있으면 잡지 못함.
- `(i+1 < N && nums[i] == nums[i+1])` 조건은 "현재와 다음 값이 같은 경우 skip"이라, 99 같은 경우가 나오지 않음.

---

### ✅ 정답 코드 (핵심 부분)

```java
int preNum = 0;
for(int i=0; i<N; i++) {
    if(!visited[i] && preNum != nums[i]) {
        visited[i] = true;
        output[depth] = nums[i];
        preNum = nums[i]; // 같은 depth에서 중복 방지
        backtracking(N, M, depth+1, nums, visited, output, sb);
        visited[i] = false;
    }
}

```

- visited 로 index 사용 여부 관리.
- preNum 으로 같은 depth에서 중복된 값 건너뜀.
- 따라서 “중복된 숫자도 올바르게 처리” + “사전 순 유지” 둘 다 충족.
