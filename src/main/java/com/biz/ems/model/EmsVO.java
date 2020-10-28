package com.biz.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmsVO {
	private long id;			//	NUMBER
	private String from_email;	//	VARCHAR2(30)
	private String to_email;	//	VARCHAR2(30)
	private String s_date;		//	VARCHAR2(10)
	private String s_time;		//	VARCHAR2(10)
	private String s_subject;	//	nVARCHAR2(125)
	private String s_content;	//	nVARCHAR2(2000)
	private String s_file1;	//	nVARCHAR2(125)
	private String s_file2;	//	nVARCHAR2(125)
}
