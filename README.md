# Инструкция подключения БД и запуска SUT
1. Склонировать проект из репозитория командой ``` git clone ```
1. Открыть склонированный проект в Intellij IDEA
1. Для запуска контейнеров с MySql, PostgreSQL и Node.js использовать команду ``` docker-compose up -d --force-recreate ```
1. Запуск SUT
- для MySQL ввести в терминале команду

``` java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app ```

- для PostgreSQL ввести в терминале команду

``` java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app ```

5. Запуск тестов (Allure)
-  для запуска на MySQL ввести команду

``` gradlew -Ddb.url=jdbc:mysql://localhost:3306/app clean test ```

- для запуска на PostgreSQ ввести команду

``` gradlew -Ddb.url=jdbc:postgresql://localhost:5432/app clean test ```

6. Открыть в Google Chrome сслыку http://localhost:8080
7. Для получения отчета (Allure) ввести команду ``` gradlew allureServe ```
8. После окончания тестов завершить работу приложения (Ctrl+C), остановить контейнеры командой ``` docker-compose down ```
