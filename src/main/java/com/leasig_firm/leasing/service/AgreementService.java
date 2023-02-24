package com.leasig_firm.leasing.service;
import com.leasig_firm.leasing.entity.Agreement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.ArrayList;
@Service
public class AgreementService {
    JdbcTemplate jdbcTemplate;

    public AgreementService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Agreement> getAllAgreement() {
        return new ArrayList<>();
    }
}
