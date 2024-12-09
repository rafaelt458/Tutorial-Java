package com.laboratorio.java152.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}