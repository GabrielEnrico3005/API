import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt(\"id\"));
        transaction.setProductID(rs.getString(\"productID\"));
        transaction.setProductName(rs.getString(\"productName\"));
        transaction.setAmount(rs.getString(\"amount\"));
        transaction.setCustomerName(rs.getString(\"customerName\"));
        transaction.setStatus(rs.getInt(\"status\"));
        transaction.setTransactionDate(rs.getString(\"transactionDate\"));
        transaction.setCreateBy(rs.getString(\"createBy\"));
        transaction.setCreateOn(rs.getString(\"createOn\"));
        return transaction;
    }
}
