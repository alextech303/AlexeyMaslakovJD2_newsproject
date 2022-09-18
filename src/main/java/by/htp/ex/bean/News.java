package by.htp.ex.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class News implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int idnews;
	private String title="";
	private String brief="";
	private String content="";
	
	public News(){}

	public News(int idnews, String title, String brief, String content, String date) {
		super();
		this.idnews = idnews;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
	}
	
	
	
	public News(String title, String brief, String content, String date) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
	}

	public int getIdnews() {
		return idnews;
	}

	public void setIdnews(int idnews) {
		this.idnews = idnews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String date;
	
	

	
	

}
