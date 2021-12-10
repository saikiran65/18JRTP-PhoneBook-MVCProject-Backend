package in.ashokit.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CONTACT_DTLS")
@Data
@NoArgsConstructor
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CONTACT_PHONENUMBER")
	private Long phoneNumber;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "CONTACT_CREATED_DATE")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "CONTACT_UPDATED_DATE")
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
}
