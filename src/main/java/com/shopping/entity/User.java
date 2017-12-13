package com.shopping.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaokai
 * @since 2017-12-01
 */
@TableName("shopping_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("addTime")
	private Date addTime;
	@TableField("deleteStatus")
	private Boolean deleteStatus;
	@TableField("MSN")
	private String msn;
	@TableField("QQ")
	private String qq;
	@TableField("WW")
	private String ww;
	private String address;
	@TableField("default_addr_id")
	private String defaultAddrId;
	@TableField("availableBalance")
	private BigDecimal availableBalance;
	private Date birthday;
	private String email;
	@TableField("freezeBlance")
	private BigDecimal freezeBlance;
	private Integer gold;
	private Integer integral;
	@TableField("lastLoginDate")
	private Date lastLoginDate;
	@TableField("lastLoginIp")
	private String lastLoginIp;
	@TableField("loginCount")
	private Integer loginCount;
	@TableField("loginDate")
	private Date loginDate;
	@TableField("loginIp")
	private String loginIp;
	private String mobile;
	private String password;
	private Integer report;
	private Integer sex;
	private Integer status;
	private String telephone;
	@TableField("trueName")
	private String trueName;
	@TableField("userName")
	private String userName;
	@TableField("userRole")
	private String userRole;
	@TableField("user_credit")
	private Integer userCredit;
	@TableField("photo_id")
	private Long photoId;
	@TableField("store_id")
	private Long storeId;
	@TableField("qq_openid")
	private String qqOpenid;
	@TableField("sina_openid")
	private String sinaOpenid;
	@TableField("store_quick_menu")
	private String storeQuickMenu;
	@TableField("parent_id")
	private Long parentId;
	private Integer years;
	@TableField("area_id")
	private Long areaId;
	@TableField("identityCard")
	private String identityCard;
    /**
     * 支付密码
     */
	@TableField("payment_code")
	private String paymentCode;
	@TableField("sellerAvailableBalance")
	private BigDecimal sellerAvailableBalance;
	@TableField("sellerFreezeBlance")
	private BigDecimal sellerFreezeBlance;
    /**
     * 移动端支付密码
     */
	@TableField("payment_mobile_code")
	private String paymentMobileCode;
	@TableField("recommendId")
	private String recommendId;
    /**
     * 用户类型，0或空 不是 1 是代购  2：是运营商 3：是运营商的商户 4：代购推荐用户 5：商户推荐用户
     */
	@TableField("isAgency")
	private Integer isAgency;
    /**
     * 代购可用余额
     */
	@TableField("agencyAvailableBalance")
	private BigDecimal agencyAvailableBalance;
    /**
     * 代购冻结金额
     */
	@TableField("agencyFreezeBlance")
	private BigDecimal agencyFreezeBlance;
	@TableField("redBlance")
	private BigDecimal redBlance;
	private Integer regeasemob;
	@TableField("wholesalerFlag")
	private String wholesalerFlag;
	private String wholsalerid;
    /**
     * B端店铺
     */
	@TableField("b2bStore_id")
	private Long b2bStoreId;
    /**
     * 是否支持货到付款 1：是 0：否
     */
	@TableField("DeliveryPay")
	private Integer DeliveryPay;
    /**
     * 0:平台普通代购 1：电信直营 2：电信合作店
     */
	private String agenttype;
    /**
     * b2b端默认收货地址
     */
	@TableField("default_b2b_addr_id")
	private String defaultB2bAddrId;
    /**
     * 电信专用 0：否 1：是
     */
	private String dxzy;
	@TableField("b2BRole_id")
	private Long b2BRoleId;
	@TableField("prizeCombineFlag")
	private String prizeCombineFlag;
	@TableField("autoRegister")
	private Integer autoRegister;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWw() {
		return ww;
	}

	public void setWw(String ww) {
		this.ww = ww;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDefaultAddrId() {
		return defaultAddrId;
	}

	public void setDefaultAddrId(String defaultAddrId) {
		this.defaultAddrId = defaultAddrId;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getFreezeBlance() {
		return freezeBlance;
	}

	public void setFreezeBlance(BigDecimal freezeBlance) {
		this.freezeBlance = freezeBlance;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getReport() {
		return report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(Integer userCredit) {
		this.userCredit = userCredit;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getQqOpenid() {
		return qqOpenid;
	}

	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}

	public String getSinaOpenid() {
		return sinaOpenid;
	}

	public void setSinaOpenid(String sinaOpenid) {
		this.sinaOpenid = sinaOpenid;
	}

	public String getStoreQuickMenu() {
		return storeQuickMenu;
	}

	public void setStoreQuickMenu(String storeQuickMenu) {
		this.storeQuickMenu = storeQuickMenu;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public BigDecimal getSellerAvailableBalance() {
		return sellerAvailableBalance;
	}

	public void setSellerAvailableBalance(BigDecimal sellerAvailableBalance) {
		this.sellerAvailableBalance = sellerAvailableBalance;
	}

	public BigDecimal getSellerFreezeBlance() {
		return sellerFreezeBlance;
	}

	public void setSellerFreezeBlance(BigDecimal sellerFreezeBlance) {
		this.sellerFreezeBlance = sellerFreezeBlance;
	}

	public String getPaymentMobileCode() {
		return paymentMobileCode;
	}

	public void setPaymentMobileCode(String paymentMobileCode) {
		this.paymentMobileCode = paymentMobileCode;
	}

	public String getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}

	public Integer getIsAgency() {
		return isAgency;
	}

	public void setIsAgency(Integer isAgency) {
		this.isAgency = isAgency;
	}

	public BigDecimal getAgencyAvailableBalance() {
		return agencyAvailableBalance;
	}

	public void setAgencyAvailableBalance(BigDecimal agencyAvailableBalance) {
		this.agencyAvailableBalance = agencyAvailableBalance;
	}

	public BigDecimal getAgencyFreezeBlance() {
		return agencyFreezeBlance;
	}

	public void setAgencyFreezeBlance(BigDecimal agencyFreezeBlance) {
		this.agencyFreezeBlance = agencyFreezeBlance;
	}

	public BigDecimal getRedBlance() {
		return redBlance;
	}

	public void setRedBlance(BigDecimal redBlance) {
		this.redBlance = redBlance;
	}

	public Integer getRegeasemob() {
		return regeasemob;
	}

	public void setRegeasemob(Integer regeasemob) {
		this.regeasemob = regeasemob;
	}

	public String getWholesalerFlag() {
		return wholesalerFlag;
	}

	public void setWholesalerFlag(String wholesalerFlag) {
		this.wholesalerFlag = wholesalerFlag;
	}

	public String getWholsalerid() {
		return wholsalerid;
	}

	public void setWholsalerid(String wholsalerid) {
		this.wholsalerid = wholsalerid;
	}

	public Long getB2bStoreId() {
		return b2bStoreId;
	}

	public void setB2bStoreId(Long b2bStoreId) {
		this.b2bStoreId = b2bStoreId;
	}

	public Integer getDeliveryPay() {
		return DeliveryPay;
	}

	public void setDeliveryPay(Integer DeliveryPay) {
		this.DeliveryPay = DeliveryPay;
	}

	public String getAgenttype() {
		return agenttype;
	}

	public void setAgenttype(String agenttype) {
		this.agenttype = agenttype;
	}

	public String getDefaultB2bAddrId() {
		return defaultB2bAddrId;
	}

	public void setDefaultB2bAddrId(String defaultB2bAddrId) {
		this.defaultB2bAddrId = defaultB2bAddrId;
	}

	public String getDxzy() {
		return dxzy;
	}

	public void setDxzy(String dxzy) {
		this.dxzy = dxzy;
	}

	public Long getB2BRoleId() {
		return b2BRoleId;
	}

	public void setB2BRoleId(Long b2BRoleId) {
		this.b2BRoleId = b2BRoleId;
	}

	public String getPrizeCombineFlag() {
		return prizeCombineFlag;
	}

	public void setPrizeCombineFlag(String prizeCombineFlag) {
		this.prizeCombineFlag = prizeCombineFlag;
	}

	public Integer getAutoRegister() {
		return autoRegister;
	}

	public void setAutoRegister(Integer autoRegister) {
		this.autoRegister = autoRegister;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", addTime=" + addTime +
			", deleteStatus=" + deleteStatus +
			", msn=" + msn +
			", qq=" + qq +
			", ww=" + ww +
			", address=" + address +
			", defaultAddrId=" + defaultAddrId +
			", availableBalance=" + availableBalance +
			", birthday=" + birthday +
			", email=" + email +
			", freezeBlance=" + freezeBlance +
			", gold=" + gold +
			", integral=" + integral +
			", lastLoginDate=" + lastLoginDate +
			", lastLoginIp=" + lastLoginIp +
			", loginCount=" + loginCount +
			", loginDate=" + loginDate +
			", loginIp=" + loginIp +
			", mobile=" + mobile +
			", password=" + password +
			", report=" + report +
			", sex=" + sex +
			", status=" + status +
			", telephone=" + telephone +
			", trueName=" + trueName +
			", userName=" + userName +
			", userRole=" + userRole +
			", userCredit=" + userCredit +
			", photoId=" + photoId +
			", storeId=" + storeId +
			", qqOpenid=" + qqOpenid +
			", sinaOpenid=" + sinaOpenid +
			", storeQuickMenu=" + storeQuickMenu +
			", parentId=" + parentId +
			", years=" + years +
			", areaId=" + areaId +
			", identityCard=" + identityCard +
			", paymentCode=" + paymentCode +
			", sellerAvailableBalance=" + sellerAvailableBalance +
			", sellerFreezeBlance=" + sellerFreezeBlance +
			", paymentMobileCode=" + paymentMobileCode +
			", recommendId=" + recommendId +
			", isAgency=" + isAgency +
			", agencyAvailableBalance=" + agencyAvailableBalance +
			", agencyFreezeBlance=" + agencyFreezeBlance +
			", redBlance=" + redBlance +
			", regeasemob=" + regeasemob +
			", wholesalerFlag=" + wholesalerFlag +
			", wholsalerid=" + wholsalerid +
			", b2bStoreId=" + b2bStoreId +
			", DeliveryPay=" + DeliveryPay +
			", agenttype=" + agenttype +
			", defaultB2bAddrId=" + defaultB2bAddrId +
			", dxzy=" + dxzy +
			", b2BRoleId=" + b2BRoleId +
			", prizeCombineFlag=" + prizeCombineFlag +
			", autoRegister=" + autoRegister +
			"}";
	}
}
