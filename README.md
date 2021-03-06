
[![Build status](https://ci.appveyor.com/api/projects/status/b269cxgr93aol4jo/branch/master?svg=true)](https://ci.appveyor.com/project/IrinaVasilenko88/diploma-qa-11/branch/master)


# Документация
[План тестирования](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/Plan.md)

[Отчёт по итогам тестирования](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/Report.md)

[Отчёт по итогам автоматизации](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/Summary.md)

# Задача:
Автоматизировать сценарии комплексного сервиса, взаимодействующего с СУБД и API Банка.
Приложение представляет из себя веб-сервис.

![](https://github.com/IrinaVasilenko88/Diploma-QA-11/blob/master/documentation/service.png)

Приложение предлагает купить тур по определённой цене с помощью двух способов:

1. Обычная оплата по дебетовой карте
1. Уникальная технология: выдача кредита по данным банковской карты


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
