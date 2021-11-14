package in.mnp200002.chatsApi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chat")
public class Chat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer msg_id;
	
	private String sub_id;
	
	private Integer user_id;
	
	private String msg;
	
	private LocalDateTime Time_stamp;
	
	private Boolean is_sent;

	public Boolean getIs_sent() {
		return is_sent;
	}

	public void setIs_sent(Boolean is_sent) {
		this.is_sent = is_sent;
	}

	public Integer getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(Integer msg_id) {
		this.msg_id = msg_id;
	}

	public String getSub_id() {
		return sub_id;
	}

	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getTime_stamp() {
		return Time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {
		Time_stamp = time_stamp;
	}
	

}
