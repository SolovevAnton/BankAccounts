# BankAccounts
Small practice project. Done in 2h. Refactored in 45 min. 
## Task

Указания к выполнению задания:
•	Все классы должны удовлетворять Code Conventions for the Java Programming Language и принципам SOLID
•	В каждом классе должны быть описаны конструкторы по умолчанию, конструкторы с параметрами, инициализирующими поля классов, методы получения и установки значений в каждое из полей класса, метод toString, методы hashCode и equals

Задание:
а) Класс счет в банке содержит поля: номер счета, код счета, фамилия владельца, сумма на счете, дата открытия счета (тип данных Date), годовой процент начисления.
Для преобразования строки в дату использовать следующий фрагмент кода:
SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
Date date = dateFormat.parse("15.12.1999");
Если на методе parse будет отображаться ошибка, то нажать alt+enter, далее add exception to method signature
б) Класс список банковских счетов. Поиск и сортировка по номеру счета, дате открытия и владельцу. Сортировку выполнить по каждому полю отдельно, а так же по совокупности всех полей

## Assumptions
1. lastName and Date cannot be null
2. duplicates are allowed in BankAccountsList
3. account list in BankAccountList cannot be null
4. null cannot be stored in BankAccountList

