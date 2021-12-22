package ru.job4j.tracker;

import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            try (Scanner scanner = new Scanner(Paths.get("db/update_001.sql"))) {
                StringBuilder sql = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    sql.append(line);
                    if (line.endsWith(";")) {
                        createStatement(sql.toString());
                        sql.setLength(0);
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps =
                     cn.prepareStatement("insert into items(name, created) values(?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            } else {
                item.setId(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement ps =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        int result = 0;
        try (Statement statement = cn.createStatement()) {
            result = statement.executeUpdate(String.format("delete from items where id = %d", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        String sql = "select * from items";
        try (ResultSet rs = selectResult(sql)) {
            while (rs.next()) {
                Item item = new Item(rs.getInt(1), rs.getString("name"));
                item.setCreated(rs.getTimestamp("created").toLocalDateTime());
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        String sql = String.format("select * from items where name like '%%%s%%'", key);
        try (ResultSet rs = selectResult(sql)) {
            while (rs.next()) {
                Item item = new Item(rs.getInt(1), rs.getString("name"));
                item.setCreated(rs.getTimestamp("created").toLocalDateTime());
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item findItem = new Item();
        String sql = String.format("select * from items where id = %d", id);
        try (ResultSet rs = selectResult(sql)) {
            if (rs.next()) {
                findItem.setId(id);
                findItem.setName(rs.getString("name"));
                findItem.setCreated(rs.getTimestamp("created").toLocalDateTime());
            } else {
                findItem = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findItem;
    }

    private void createStatement(String sql) throws SQLException {
        try (Statement statement = cn.createStatement()) {
            statement.execute(sql);
        }
    }

    private ResultSet selectResult(String sql) throws SQLException {
        try (Statement statement = cn.createStatement()) {
            return statement.executeQuery(sql);
        }
    }
}
