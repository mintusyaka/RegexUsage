![image](https://github.com/user-attachments/assets/443414f3-71f1-41fe-92c5-12a346be997e)# ЯК ЗГЕНЕРУВАТИ ФАЙЛИ:
## orders.txt
1. Відкрити OrdersGeneratorApp.java
2. Вказати бажану кількість згенерованих замовлень
   ![image](https://github.com/user-attachments/assets/89fe22e7-fa34-408f-a2b9-242500445ecf)
3. Запустити

## students.txt
1. Відкрити StudentsGeneratorApp.java
2. Вказати бажану кількість згенерованих студентів
   ![image](https://github.com/user-attachments/assets/d782b595-5c3d-46dc-9230-6baa7b1bad58)
3. Запустити

---

### Формат рядку з замовленням:
```
Username: _, Order ID: _, Status: _;
```
### Функція, що фільтрує замовлення за статусом:
```
public static List<String> getRowsByStatus(List<String> rows, String status) {
        String regex = "Status: (" + status + ");.*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }
```
### Функція, що фільтрує замовлення за іменем користувача:
```
public static List<String> getRowsByNicknamePart(List<String> rows, String partOfNickname) {
    String regex = "Username: .*?" + Pattern.quote(partOfNickname) + ".*?, Order ID: .*";

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> line.matches(regex))
            .forEach(resultList::add);

    return resultList;
}
```
---

### Формат рядку з студентом:
```
Name: Name Surname, Email: name.surname.GROUP.year@lpnu.ua, Group: GROUP-11, Year: year;
```
### Функція, що фільтрує студентів за роком вступу:
```
private static List<String> getStudentsByYear(List<String> rows, String years) {
    if(years.isEmpty())
        return rows;

    String regex = "Year: (" + years + ");.*";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            })
            .forEach(resultList::add);

    return resultList;
}
```
### Функція, що фільтрує студентів за спеціальністю:
```
public static List<String> getStudentsByGroupName(List<String> rows, String groupNames) {
    if(groupNames.isEmpty())
        return rows;

    String regex = ".*Email:\\s*\\w+\\.\\w+\\.("+ groupNames +")\\.\\d{4}@lpnu\\.ua.*";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            })
            .forEach(resultList::add);

    return resultList;
}
```
### Функція, що фільтрує студентів за іменем:
```
private static List<String> filterByName(List<String> rows, String name) {
    if(name.isEmpty())
        return rows;

    String regex = ".*Email:\\s*" + name.toLowerCase() + "\\.[a-zA-Z]+";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            })
            .forEach(resultList::add);

    return resultList;
}
```
### Функція, що фільтрує студентів за прізвищем:
```
private static List<String> filterBySurname(List<String> rows, String surname) {
    if(surname.isEmpty())
        return rows;

    String regex = ".*Email:\\s*[a-zA-Z]+\\." + surname.toLowerCase() + "\\.[a-zA-Z]+";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> {
                Matcher matcher = pattern.matcher(line);
                return matcher.find();
            })
            .forEach(resultList::add);

    return resultList;
}
```
