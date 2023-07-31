package homework12_2.part2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    directorRes.setFirstName(resultSet.getString(2));
                    directorRes.setLastName(resultSet.getString(3));
                    directorRes.setBirthDate(resultSet.getDate(4));
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
            statement.setString(2, director.getFirstName());
            statement.setString(3, director.getLastName());
            statement.setDate(4, director.getBirthDate());
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
     * @param size размер списка, сколько нужно параметров для запроса
     * @return строка типа ?, ?, ? для параметризованного sql запроса
     */
    private static String getQuestionMarks(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("?");
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public List<Director> get(List<String> genres) {
        DirectorRepositoryImpl directors = new DirectorRepositoryImpl();
        List<Director> resultList = new ArrayList<>();
        if (genres.size() > 0) {
            String sql = "SELECT DISTINCT \"director\" FROM \"Movies\" WHERE \"genre\" IN (" + getQuestionMarks(genres.size()) + ")";

            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(sql);
                // Задание параметров запроса для каждого жанра
                for (int i = 0; i < genres.size(); i++) {
                    statement.setString(i + 1, genres.get(i));
                }

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Director dir = directors.get(resultSet.getInt(1));
                    System.out.println("Найдены следующие режиссёры:");
                    if (dir != null) {
                        resultList.add(dir);
                        System.out.printf("DirectorID: %s, Имя:%s %s\n\n", dir.getId(), dir.getFirstName(), dir.getLastName());
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    // Вспомогательный метод для проверки наличия жанра у режиссера
    public boolean hasGenre(Director director, String genre) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            boolean isSelected = statement.execute(String.format("SELECT DISTINCT \"genre\"  FROM \"Movies\" WHERE \"director\" = %d ", director.getId()));

            if (isSelected) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    result = genre.equals(resultSet.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * Метод подготовки базы к проверкам: удаление всей информации из базы и добавление трёх записей
     */
    void prepareDB() {
        PreparedStatement statement;
        try {
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
