package enums;

public enum ErrosDoSQL {

    STRING_DATA_RIGHT_TRUNCATION("22001"),
    INTEGRITY_CONSTRAINT_VIOLATION("23000"),
    RESTRICT_VIOLATION("23001"),
    NOT_NULL_VIOLATION("23502"),
    FOREIGN_KEY_VIOLATION("23503"),
    UNIQUE_VIOLATION("23505"),
    CHECK_VIOLATION("23514"),
    EXCLUSION_VIOLATION("23P01");

    private final String sqlState;

    ErrosDoSQL(String sqlState) {

        this.sqlState = sqlState;

    }

    public String getSqlState() {

        return sqlState;

    }

    public static boolean foiCausadoPorConstraint(String sqlState){

        for (ErrosDoSQL errosDoSQL : ErrosDoSQL.values()){

            if(errosDoSQL.getSqlState().equalsIgnoreCase(sqlState)){

                return true;

            }

        }

        return false;

    }

}
