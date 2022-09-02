package ru.baib.iac.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.baib.iac.model.Contact;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactJDBCTemplate implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContactJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Contact save(Contact contact) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insert = "insert into contacts(name, number, created) values (?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            LocalDateTime created = LocalDateTime.now();
            ps.setTimestamp(3, Timestamp.valueOf(created));
            contact.setCreated(created);
            return ps;
        }, keyHolder);
        contact.setId((Integer) keyHolder.getKeys().get("id"));
        return contact;
    }

    public List<Contact> findAll() {
        String findAll = "select * from contacts";
        return jdbcTemplate.query(findAll,
                (rs, row) -> {
                    Contact contact = new Contact();
                    contact.setId(rs.getInt("id"));
                    contact.setName(rs.getString("name"));
                    contact.setNumber(rs.getString("number"));
                    contact.setCreated(rs.getTimestamp("created").toLocalDateTime());
                    return contact;
                });
    }

    public void update(Contact contact) {
        String update = "update contacts set name = ?, number = ?, created = ? where id = ?";
        jdbcTemplate.update(update,
                contact.getName(),
                contact.getNumber(),
                Timestamp.valueOf(LocalDateTime.now()),
                contact.getId());
    }

    public void delete(Integer id) {
        String delete = "delete from contacts where id = ?";
        jdbcTemplate.update(delete, id);
    }

}
