package in.ashokit.bindings;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContactForm {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phoneNumber;
	private String activeSw;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
