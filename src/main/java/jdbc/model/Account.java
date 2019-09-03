package jdbc.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Account {

	private Integer id;

	private String email;

	private String password;

	private String gender;

	private Integer status;
}