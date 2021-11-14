package in.mnp200002.chatsApi.model;

import java.time.LocalDateTime;

public class FinalChat {
	
	private Integer msg_id;
	
	private String sub_id;
	
	private Integer user_id;
	
	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setTime_stamp(LocalDateTime localDateTime) {
		Time_stamp = localDateTime;
	}

	public Boolean getIs_sent() {
		return is_sent;
	}

	public void setIs_sent(Boolean is_sent) {
		this.is_sent = is_sent;
	}

	private String msg;
	
	private LocalDateTime Time_stamp;
	
	private Boolean is_sent;

}
