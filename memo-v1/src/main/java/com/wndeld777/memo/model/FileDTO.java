package com.wndeld777.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {

	private Long f_seq;
	private Long f_gseq;
	private String f_original;
	private String f_upname;
}
