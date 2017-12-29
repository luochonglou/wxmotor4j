package org.wxmotor4j.third.response;

import java.util.List;

import org.wxmotor4j.third.api.WXThirdResponse;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse.AuthorizationInfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdGetAuthorizerInfoResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetAuthorizerInfoResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -2590369495996893083L;

	@JSONField(name = "authorizer_info")
	private AuthorizerInfo AuthorizerInfo;

	@JSONField(name = "authorization_info")
	private AuthorizationInfo authorizationInfo;

	public AuthorizerInfo getAuthorizerInfo() {
		return AuthorizerInfo;
	}

	public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
		AuthorizerInfo = authorizerInfo;
	}

	public AuthorizationInfo getAuthorizationInfo() {
		return authorizationInfo;
	}

	public void setAuthorizationInfo(AuthorizationInfo authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

	public static class AuthorizerInfo {
		@JSONField(name = "nick_name")
		private String nickName;

		@JSONField(name = "head_img")
		private String headImg;

		@JSONField(name = "service_type_info")
		private ServiceTypeInfo serviceTypeInfo;

		@JSONField(name = "verify_type_info")
		private VerifyTypeInfo verifyTypeInfo;

		@JSONField(name = "user_name")
		private String userName;

		@JSONField(name = "principal_name")
		private String principalName;

		@JSONField(name = "business_info")
		private BusinessInfo businessInfo;

		@JSONField(name = "alias")
		private String alias;

		@JSONField(name = "qrcode_url")
		private String qrcodeUrl;

		@JSONField(name = "signature")
		private String signature;

		@JSONField(name = "MiniProgramInfo")
		private MiniProgramInfo miniProgramInfo;

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		public String getHeadImg() {
			return headImg;
		}

		public void setHeadImg(String headImg) {
			this.headImg = headImg;
		}

		public ServiceTypeInfo getServiceTypeInfo() {
			return serviceTypeInfo;
		}

		public void setServiceTypeInfo(ServiceTypeInfo serviceTypeInfo) {
			this.serviceTypeInfo = serviceTypeInfo;
		}

		public VerifyTypeInfo getVerifyTypeInfo() {
			return verifyTypeInfo;
		}

		public void setVerifyTypeInfo(VerifyTypeInfo verifyTypeInfo) {
			this.verifyTypeInfo = verifyTypeInfo;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPrincipalName() {
			return principalName;
		}

		public void setPrincipalName(String principalName) {
			this.principalName = principalName;
		}

		public BusinessInfo getBusinessInfo() {
			return businessInfo;
		}

		public void setBusinessInfo(BusinessInfo businessInfo) {
			this.businessInfo = businessInfo;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}

		public String getQrcodeUrl() {
			return qrcodeUrl;
		}

		public void setQrcodeUrl(String qrcodeUrl) {
			this.qrcodeUrl = qrcodeUrl;
		}

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

		public MiniProgramInfo getMiniProgramInfo() {
			return miniProgramInfo;
		}

		public void setMiniProgramInfo(MiniProgramInfo miniProgramInfo) {
			this.miniProgramInfo = miniProgramInfo;
		}

	}

	public static class MiniProgramInfo {
		@JSONField(name = "network")
		private network network;

		@JSONField(name = "categories")
		private List<categories> categories;

		@JSONField(name = "visit_status")
		private Integer visitStatus;

		public network getNetwork() {
			return network;
		}

		public void setNetwork(network network) {
			this.network = network;
		}

		public List<categories> getCategories() {
			return categories;
		}

		public void setCategories(List<categories> categories) {
			this.categories = categories;
		}

		public Integer getVisitStatus() {
			return visitStatus;
		}

		public void setVisitStatus(Integer visitStatus) {
			this.visitStatus = visitStatus;
		}

	}

	public static class network {
		@JSONField(name = "RequestDomain")
		private List<String> requestDomain;

		@JSONField(name = "WsRequestDomain")
		private List<String> wsRequestDomain;

		@JSONField(name = "UploadDomain")
		private List<String> uploadDomain;

		@JSONField(name = "DownloadDomain")
		private List<String> downloadDomain;

		public List<String> getRequestDomain() {
			return requestDomain;
		}

		public void setRequestDomain(List<String> requestDomain) {
			this.requestDomain = requestDomain;
		}

		public List<String> getWsRequestDomain() {
			return wsRequestDomain;
		}

		public void setWsRequestDomain(List<String> wsRequestDomain) {
			this.wsRequestDomain = wsRequestDomain;
		}

		public List<String> getUploadDomain() {
			return uploadDomain;
		}

		public void setUploadDomain(List<String> uploadDomain) {
			this.uploadDomain = uploadDomain;
		}

		public List<String> getDownloadDomain() {
			return downloadDomain;
		}

		public void setDownloadDomain(List<String> downloadDomain) {
			this.downloadDomain = downloadDomain;
		}

	}

	public static class categories {
		@JSONField(name = "first")
		private String first;

		@JSONField(name = "second")
		private String second;

		public String getFirst() {
			return first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getSecond() {
			return second;
		}

		public void setSecond(String second) {
			this.second = second;
		}

	}

	public static class ServiceTypeInfo {
		@JSONField(name = "id")
		Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	}

	public static class VerifyTypeInfo {

		@JSONField(name = "id")
		Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	}

	public static class BusinessInfo {
		@JSONField(name = "open_store")
		private Integer openStore;

		@JSONField(name = "open_scan")
		private Integer openScan;

		@JSONField(name = "open_pay")
		private Integer openPay;

		@JSONField(name = "open_card")
		private Integer openCard;

		@JSONField(name = "open_shake")
		private Integer openShake;

		public Integer getOpenStore() {
			return openStore;
		}

		public void setOpenStore(Integer openStore) {
			this.openStore = openStore;
		}

		public Integer getOpenScan() {
			return openScan;
		}

		public void setOpenScan(Integer openScan) {
			this.openScan = openScan;
		}

		public Integer getOpenPay() {
			return openPay;
		}

		public void setOpenPay(Integer openPay) {
			this.openPay = openPay;
		}

		public Integer getOpenCard() {
			return openCard;
		}

		public void setOpenCard(Integer openCard) {
			this.openCard = openCard;
		}

		public Integer getOpenShake() {
			return openShake;
		}

		public void setOpenShake(Integer openShake) {
			this.openShake = openShake;
		}

	}
}
