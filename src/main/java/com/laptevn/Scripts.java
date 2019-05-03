package com.laptevn;

public final class Scripts {
    public final static String QUERY_BY_ID = "SELECT name FROM bank WHERE bank_identifier = ?";
    public final static String INSERT = "INSERT INTO bank VALUES (:id, :name)";
}