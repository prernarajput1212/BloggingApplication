package com.Blogging.Payloads;

public class SendSms {
	private String dcode="SPICEJTEST";
    private  String subuid="SPICEJTEST";
    private  String pwd="HaswWul+RC+le/lITEra1Q==";
    private String to="6395394857";
    private String msgtxt="Spicejet Pre Flight Info:-\r\n\r\nSector : 1\r\nSG 89/30-Dec-2022/DELBKK\r\n2022-12-30T08:30/VT-SZJ/737-800/\r\nETA:06:52(Bay A12R)178/10/0/BOB TGT: NA\r\n2CORP/3MAXP/23BVG1/1CHML/1NCC1/2NCC4/1NVSW/1VCC2/1VCC5/6VGM1/21VGML/4VGS1/8VGSW/4VMAX/\r\n\r\nSector : 2\r\nSG 90/30-Dec-2022/BKKDEL\r\n2022-12-31T13:50/VT-SZJ/737-800/\r\nETA:13:00(Bay )143/7/2/BOB TGT: NA\r\n2BVG/22BVG1/1NCC1/1NCC6/1NVM1/1NVS1/3VGM1/9VGML/1VGS1/11VGSW/\r\n\r\n";
  //  private String msgtxt="this is text";
    private  String msgtype="S";
    private  String from="SPICEJ";
    private  String OTPFlag="0";
    private String ctype="1";


    public String getmsgtxt() {
        return msgtxt;
    }

    public String getDcode() {
		return dcode;
	}

	public void setDcode(String dcode) {
		this.dcode = dcode;
	}

	public String getSubuid() {
		return subuid;
	}

	public void setSubuid(String subuid) {
		this.subuid = subuid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getOTPFlag() {
		return OTPFlag;
	}

	public void setOTPFlag(String oTPFlag) {
		OTPFlag = oTPFlag;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public void setmsgtxt(String msgtxt) {
        this.msgtxt = msgtxt;
    }


}
