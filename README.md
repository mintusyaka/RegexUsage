Функція, що фільтрує замовлення за статусом:
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

Функція, що фільтрує замовлення за іменем користувача:
public static List<String> getRowsByNicknamePart(List<String> rows, String partOfNickname) {
    String regex = "Username: .*?" + Pattern.quote(partOfNickname) + ".*?, Order ID: .*";

    List<String> resultList = new ArrayList<>();

    rows.stream()
            .filter(line -> line.matches(regex))
            .forEach(resultList::add);

    return resultList;
}

Функція, що фільтрує студентів за роком вступу:
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

Функція, що фільтрує студентів за спеціальністю:
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

Функція, що фільтрує студентів за іменем:
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

Функція, що фільтрує студентів за прізвищем:
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
