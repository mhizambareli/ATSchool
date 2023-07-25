package homework12_2.part1;

import java.sql.*;

public class DirectorRepositoryImpl implements DirectorRepository {
    Connection connection;

    public DirectorRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Homework12_1", "postgres", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Director get(int id) {
        Director directorRes = null;
        try {
            Statement statement = connection.createStatement();
            boolean isSelect = statement.execute("SELECT * FROM public.\"Directors\" WHERE \"id\" = " + id);
            if (isSelect) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    directorRes = new Director();
                    directorRes.setId(resultSet.getInt(1));
                    directorRes.setFirst_name(resultSet.getString(2));
                    directorRes.setLast_name(resultSet.getString(3));
                    directorRes.setBirth_date(resultSet.getDate(4));
                    directorRes.setCountry(resultSet.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return directorRes;
    }

    @Override
    //сохраняет запись в таблицу
    public void save(Director director) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"Directors\" VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, director.getId());
            statement.setString(2, director.getFirst_name());
            statement.setString(3, director.getLast_name());
            statement.setDate(4, director.getBirth_date());
            statement.setString(5, director.getCountry());
            int row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //удаляет запись в таблице
    public void delete(Director director) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM public.\"Directors\" WHERE id = ?");
            statement.setInt(1, director.getId());
            int row = statement.executeUpdate();
            System.out.println("Удалено " + row + " строк");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод подготовки базы к проверкам: удаление всей информации из базы и добавление трёх записей
     */
    void prepareDB() {
        PreparedStatement statement;
        try {
            //Мне лень было дублировать базу данных для второго задания, поэтому тут тоже чищу таблицу Movies, которой по первому заданию ещё нет.
            statement = connection.prepareStatement("DELETE FROM public.\"Movies\"");
            int row = statement.executeUpdate();
            System.out.println("Удалено " + row + " строк");

            statement = connection.prepareStatement("DELETE FROM public.\"Directors\"");
            row = statement.executeUpdate();
            System.out.println("Удалено " + row + " строк");

            statement = connection.prepareStatement("INSERT INTO public.\"Directors\" VALUES (?, ?, ?, ?, ?)");

            statement.setInt(1, 1);
            statement.setString(2, "Кейт");
            statement.setString(3, "Смит");
            statement.setDate(4, Date.valueOf("1984-11-18"));
            statement.setString(5, "США");
            row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");

            statement.setInt(1, 2);
            statement.setString(2, "Пётр");
            statement.setString(3, "Петров");
            statement.setDate(4, Date.valueOf("1952-10-30"));
            statement.setString(5, "Беларусь");
            statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");

            statement.setInt(1, 3);
            statement.setString(2, "Иван");
            statement.setString(3, "Иванов");
            statement.setDate(4, Date.valueOf("1999-05-11"));
            statement.setString(5, "Россия");
            statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}