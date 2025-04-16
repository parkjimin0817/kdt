package com.kh.boot.domain.vo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    private int formNo;
    private String formTitle;
    private String formWriter;
    private String formResponseUrl;
    private Date createDate;
    private String status;
    private String formDashboardUrl;
}
