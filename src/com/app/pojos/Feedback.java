package com.app.pojos;


import javax.persistence.*;


@Entity
@Table(name="FEEDBACK")
public class Feedback 
{
	private Integer feedbackId;
	private String email;
	private String messege;
	private String subject;
	public Feedback() 
	{
		System.out.println("in Fedback...ctr..");
	}
 
	public Feedback(String email, String messege, String subject) {
		super();
		
		this.email = email;
		this.messege = messege;
		this.subject = subject;
	}


	
	
	public Feedback(Integer feedbackId, String email, String messege, String subject) {
		super();
		this.feedbackId = feedbackId;
		this.email = email;
		this.messege = messege;
		this.subject = subject;
	}




	@Id
	@GeneratedValue
	@Column(name="FeedbackId")
	public Integer getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	@Column(name="Email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="Messege")
	public String getMessege() {
		return this.messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}
	@Column(name="Subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", email=" + email + ", messege=" + messege + ", subject="
				+ subject + "]";
	}
	
	

}