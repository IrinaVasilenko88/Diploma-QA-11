# Документация
[План тестирования](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/Plan.md)

[Отчёт по итогам тестирования](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/%D0%9E%D1%82%D1%87%D1%91%D1%82%20%D0%BF%D0%BE%20%D0%B8%D1%82%D0%BE%D0%B3%D0%B0%D0%BC%20%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F.md)

[Отчётные документы по итогам автоматизации]()

# Инструкция подключения БД и запуска SUT
1. Склонировать проект из репозитория командой ``` git clone ```
1. Открыть склонированный проект в Intellij IDEA
1. Для запуска контейнеров с MySql, PostgreSQL и Node.js использовать команду ``` docker-compose up -d --force-recreate ```
1. Запуск SUT
- для MySQL ввести в терминале команду

``` java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app  -jar artifacts/aqa-shop.jar```

- для PostgreSQL ввести в терминале команду

``` java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app  -jar artifacts/aqa-shop.jar ```

5. Запуск тестов (Allure)
-  для запуска на MySQL ввести команду

``` gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app allureReport ```

- для запуска на PostgreSQ ввести команду

``` gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app allureReport ```

6. Открыть в Google Chrome сслыку http://localhost:8080
7. Для получения отчета Allure в браузере ввести команду ``` gradlew allureServe ```
8. После окончания тестов завершить работу приложения (Ctrl+C), остановить контейнеры командой ``` docker-compose down ```
