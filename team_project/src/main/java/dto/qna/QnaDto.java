package dto.qna;

import java.util.Date;

public class QnaDto {
	private int qNumber;
	private String qTitle;
	private String qna;
	private String name;
	private Date qDate;
	private String email;
	private int qRef;
	private int qStep;
	private int qDepth;
	
	public QnaDto() {}
	
	public QnaDto(int qNumber, String qTitle, String qna, String name, String email, int qRef, int qStep, int qDepth) {
		super();
		this.qNumber = qNumber;
		this.qTitle = qTitle;
		this.qna = qna;
		this.name = name;
		this.email = email;
		this.qRef = qRef;
		this.qStep = qStep;
		this.qDepth = qDepth;
	}

	public int getqNumber() {
		return qNumber;
	}

	public void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getQna() {
		return qna;
	}

	public void setQna(String qna) {
		this.qna = qna;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getqRef() {
		return qRef;
	}

	public void setqRef(int qRef) {
		this.qRef = qRef;
	}

	public int getqStep() {
		return qStep;
	}

	public void setqStep(int qStep) {
		this.qStep = qStep;
	}

	public int getqDepth() {
		return qDepth;
	}

	public void setqDepth(int qDepth) {
		this.qDepth = qDepth;
	}
	
}
