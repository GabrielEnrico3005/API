

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
class ApiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(\"/viewData\")
    public ResponseEntity<Map<String, Object>> getViewData() {
        String query = \"SELECT * FROM transactions\";
        List<Transaction> transactions = jdbcTemplate.query(query, new TransactionRowMapper());

        String statusQuery = \"SELECT * FROM status\";
        List<Status> statuses = jdbcTemplate.query(statusQuery, new StatusRowMapper());

        return ResponseEntity.ok(Map.of(
            \"data\", transactions,
            \"status\", statuses
        ));
    }
}
