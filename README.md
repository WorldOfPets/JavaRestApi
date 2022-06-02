# Spherum REST API
## Instruction for run project
1. Download or clone the project
2. Open a terminal or console and go to the project folder (cd C:/.../demo)
3. Enter the next commands
4. For windows: 
``` 
gradlew build
gradlew bootRun
```
5. For linux:
```
./gradlew build
./gradlew bootRun
```
## Instruction for API
1. Use localhost on port 8080 
2. GET /account ```http://localhost:8080/account```
```json
{
    "books": [
        {
            "book": {
                "name": "Совершенный код",
                "author": "Стив Макконелл"
            },
            "amount": 0
        },
        {
            "book": {
                "name": "Философия Java",
                "author": "Брюс Эккель"
            },
            "amount": 15
        },
        {
            "book": {
                "name": "Effective Java",
                "author": "Joshua Bloch"
            },
            "amount": 10
        }
    ],
    "balance": 13000
}
```
3. GET /market ```http://localhost:8080/market``` (without books with amount equals 0)
```json
{
    "products": [
        {
            "id": 1,
            "book": {
                "name": "Философия Java",
                "author": "Брюс Эккель"
            },
            "price": 1500,
            "amount": 15
        },
        {
            "id": 2,
            "book": {
                "name": "Effective Java",
                "author": "Joshua Bloch"
            },
            "price": 2500,
            "amount": 10
        }
    ]
}
```
4. POST /market/deal ```http://localhost:8080/market/deal```
- Body:
```json
{
  "id": 0, 
  "amount": 7
}
```
- Responce:
```
Куплена книга!
Название: Совершенный код
Автор: Стив Макконелл
Количество: 7
Цена: 7000
Баланс: 13000
Остаток книг: 0
```
### Feature
- data.json in project (demo/src/main/java/com/example/demo/jsonParser/data.json)
- No tests because no errors xD.
- No comment because it's understandable, maybe. I believe in you...)
