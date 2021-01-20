package dto;

public class AddRegDto {
    private String regId;
    private String mid;
    private String  regDate;
    private String memberName;
    private String email;
    private String dob;
    private int mobileNo;
    private String address;
    private String payId;
    private double amount;
    private String pDate;
    private String type;
    private String gid;
    private String gName;
    private String gType;
    private String gMobile;
    private String gAddress;
    private String gEmail;

    public AddRegDto() {
    }

    public AddRegDto(String regId, String mid, String regDate, String memberName, String email, String dob, int mobileNo, String address, String payId, double amount, String pDate, String type, String gid, String gName, String gType, String gMobile, String gAddress, String gEmail) {
        this.setRegId(regId);
        this.setMid(mid);
        this.setRegDate(regDate);
        this.setMemberName(memberName);
        this.setEmail(email);
        this.setDob(dob);
        this.setMobileNo(mobileNo);
        this.setAddress(address);
        this.setPayId(payId);
        this.setAmount(amount);
        this.setpDate(pDate);
        this.setType(type);
        this.setGid(gid);
        this.setgName(gName);
        this.setgType(gType);
        this.setgMobile(gMobile);
        this.setgAddress(gAddress);
        this.setgEmail(gEmail);
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public String getgMobile() {
        return gMobile;
    }

    public void setgMobile(String gMobile) {
        this.gMobile = gMobile;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public String getgEmail() {
        return gEmail;
    }

    public void setgEmail(String gEmail) {
        this.gEmail = gEmail;
    }
}
