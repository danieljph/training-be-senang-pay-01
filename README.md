# Training BE SenangPay - Spring Framework
Contains sample code related to training Senang Pay.

# Liquibase Commands
```
liquibase --changeLogFile=db/master.changelog.yaml --url=jdbc:postgresql://localhost:5432/training_senang_pay --username=postgres --password=postgres generate-changelog

liquibase --changeLogFile=db/master.changelog.yaml --url=jdbc:postgresql://localhost:5432/training_senang_pay --username=postgres --password=postgres update

liquibase --changeLogFile=db/master.changelog.yaml --url=jdbc:postgresql://localhost:5432/training_senang_pay --username=postgres --password=postgres rollback --tag=DP-0001-1

liquibase --changeLogFile=db/master.changelog.yaml --url=jdbc:postgresql://localhost:5432/training_senang_pay --username=postgres --password=postgres rollbackCount 2
```

# PostgreSQL
## Truncate Tables
```
TRUNCATE TABLE payment RESTART IDENTITY CASCADE;
TRUNCATE TABLE inquiry RESTART IDENTITY CASCADE;
TRUNCATE TABLE register RESTART IDENTITY CASCADE;
```
