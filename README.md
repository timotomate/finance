# 💰 Finance Transaction API(2025.06.05)

Spring Boot와 JPA를 사용한 간단한 금융 거래 관리 API 프로젝트
사용자(User), 계좌(Account), 거래(Transaction) 데이터를 기반으로 입출금 등록 및 월별 거래 요약 제공.
(DTO사용 안 함)

---

## 📌 주요 기능

- 사용자 등록
- 계좌 등록 및 조회
- 거래 등록 (입금 / 출금)
- 계좌별 전체 거래 내역 조회
- 월별 거래 요약 조회 (입금/출금 합산)

---

## ⚙️ 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- MySQL 8.x
- Lombok
- Gradle
- Postman (API 테스트용)

---

## 🗂️ API 명세

### 🧑 사용자 등록
- **Endpoint**: `POST /users`
- **Request Params** (x-www-form-urlencoded 또는 JSON):
    - `name` (String) - 사용자 이름
    - `email` (String) - 사용자 이메일
    - ![image](https://github.com/user-attachments/assets/d87f7cee-7191-4d83-8eee-44d05ef13e92)



---

### 💳 계좌 등록
- **Endpoint**: `POST /accounts`
- **Request Params**:
    - `userId` (Long) - 사용자 ID
    - `bankName` (String) - 은행 이름
    - `accountNumber` (String) - 계좌 번호
    - ![image](https://github.com/user-attachments/assets/a5e26d4b-2e3f-48f4-b0ee-69217ced2985)


---

### 💰 거래 등록
- **Endpoint**: `POST /transactions`
- **Request Params**:
    - `accountId` (Long) - 계좌 ID
    - `amount` (Long) - 금액
    - `type` (String) - 거래 타입 (`DEPOSIT` 또는 `WITHDRAWAL`)
    - ![image](https://github.com/user-attachments/assets/b1c2dd16-6cbd-432f-a4a8-b7430540b0d5)


---

### 📜 거래 전체 조회 (계좌별)
- **Endpoint**: `GET /transactions?accountId={id}`
- **Response**: 해당 계좌의 모든 거래 내역 (JSON 배열)

---

### 📊 월별 거래 요약
- **Endpoint**: `GET /transactions/summary?accountId={id}&year={year}&month={month}`
- **Response Example**:

```json
[
  {
    "type": "DEPOSIT",
    "totalAmount": 30000
  },
  {
    "type": "WITHDRAWAL",
    "totalAmount": 5000
  }
]
