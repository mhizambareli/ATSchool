package homework12_2.part2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    Connection connection;

    public MovieRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Homework12_1", "postgres", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie get(int id) {
        Movie movieRes = null;
        try {
            Statement statement = connection.createStatement();
            boolean isSelect = statement.execute("SELECT * FROM public.\"Movies\" WHERE \"id\" = " + id);
            if (isSelect) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    movieRes = new Movie();
                    movieRes.setId(resultSet.getInt(1));
                    movieRes.setTitle(resultSet.getString(2));
                    movieRes.setGenre(resultSet.getString(3));
                    movieRes.setRelease(resultSet.getDate(4));
                    movieRes.setDirectorId(resultSet.getInt(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movieRes;
    }

    @Override
    public void save(Movie movie) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"Movies\" VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setDate(4, movie.getRelease());
            statement.setInt(5, movie.getDirectorId());
            int row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Movie movie) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM public.\"Movies\" WHERE id = " + movie.getId());
            int row = statement.executeUpdate();
            System.out.println("Удалено " + row + " строк");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movie> get(Director d) {
        List<Movie> resultList = new ArrayList<>();
        Movie movie;
        try {
            Statement statement = connection.createStatement();
            boolean isSelect = statement.execute("SELECT * FROM public.\"Movies\" WHERE \"director\" = " + d.getId());
            if (isSelect) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    movie = new Movie();
                    movie.setId(resultSet.getInt(1));
                    movie.setTitle(resultSet.getString(2));
                    movie.setGenre(resultSet.getString(3));
                    movie.setRelease(resultSet.getDate(4));
                    movie.setDirectorId(resultSet.getInt(5));
                    resultList.add(movie);
                }
            }
            System.out.println("Найдены фильмы:");
            for (Movie curr : resultList) {
                System.out.printf("Название: %s\nЖанр: %s\nДата релиза: %s\n\n", curr.getTitle(), curr.getGenre(), curr.getRelease());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    void prepareDB() {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"Movies\" VALUES (?, ?, ?, ?, ?)");

            statement.setInt(1, 1);
            statement.setString(2, "Смешной фильм");
            statement.setString(3, "Комедия");
            statement.setDate(4, Date.valueOf("2023-09-13"));
            statement.setInt(5, 1);
            int row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");

            statement.setInt(1, 2);
            statement.setString(2, "Космическая одиссея");
            statement.setString(3, "Фэнтази");
            statement.setDate(4, Date.valueOf("2014-07-05"));
            statement.setInt(5, 3);
            row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");

            statement.setInt(1, 3);
            statement.setString(2, "Она не может любить меня!");
            statement.setString(3, "Мелодрама");
            statement.setDate(4, Date.valueOf("2005-02-18"));
            statement.setInt(5, 1);
            row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");

            statement.setInt(1, 4);
            statement.setString(2, "Смешной и ещё смешнее");
            statement.setString(3, "Комедия");
            statement.setDate(4, Date.valueOf("2009-10-10"));
            statement.setInt(5, 2);
            row = statement.executeUpdate();
            System.out.println("Добавлена " + row + " строка");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
