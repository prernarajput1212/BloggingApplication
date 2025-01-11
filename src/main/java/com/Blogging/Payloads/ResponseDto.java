package com.Blogging.Payloads;

import java.util.List;

public class ResponseDto {
	 public ResponseDto(String status, String messageid, String responseid, String errCode, String errDescritption) {
	        this.status = status;
	        this.messageid = messageid;
	        this.responseid = responseid;
	        this.errCode = errCode;
	        this.errDescritption = errDescritption;
	      //  this.message = message;
	    }

	    String status;
	    String messageid;

	    public String getMessageid() {
	        return messageid;
	    }

	    public String getErrDescritption() {
	        return errDescritption;
	    }

	    public void setErrDescritption(String errDescritption) {
	        this.errDescritption = errDescritption;
	    }

	    public String getErrCode() {
	        return errCode;
	    }

	    public void setErrCode(String errCode) {
	        this.errCode = errCode;
	    }

	    public String getResponseid() {
	        return responseid;
	    }

	    public void setResponseid(String responseid) {
	        this.responseid = responseid;
	    }

	    public void setMessageid(String messageid) {
	        this.messageid = messageid;
	    }

	    String responseid;
	    String errCode;
	    String errDescritption;
	   // String message;
	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	}



