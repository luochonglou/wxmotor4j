package org.wxmotor4j.third.response;

import java.util.List;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdQueryComponentAuthResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdQueryComponentAuthResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@JSONField(name = "authorization_info")
	private AuthorizationInfo authorizationInfo;

	public AuthorizationInfo getAuthorizationInfo() {
		return authorizationInfo;
	}

	public void setAuthorizationInfo(AuthorizationInfo authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

	public static class AuthorizationInfo {
		@JSONField(name = "authorizer_appid")
		private String authorizerAppid;

		@JSONField(name = "authorizer_access_token")
		private String authorizerAccessToken;

		@JSONField(name = "expires_in")
		private Integer expiresIn;

		@JSONField(name = "authorizer_refresh_token")
		private String authorizerRefreshToken;

		@JSONField(name = "func_info")
		private List<FuncInfo> funcInfo;

		public String getAuthorizerAppid() {
			return authorizerAppid;
		}

		public void setAuthorizerAppid(String authorizerAppid) {
			this.authorizerAppid = authorizerAppid;
		}

		public String getAuthorizerAccessToken() {
			return authorizerAccessToken;
		}

		public void setAuthorizerAccessToken(String authorizerAccessToken) {
			this.authorizerAccessToken = authorizerAccessToken;
		}

		public Integer getExpiresIn() {
			return expiresIn;
		}

		public void setExpiresIn(Integer expiresIn) {
			this.expiresIn = expiresIn;
		}

		public String getAuthorizerRefreshToken() {
			return authorizerRefreshToken;
		}

		public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
			this.authorizerRefreshToken = authorizerRefreshToken;
		}

		public List<FuncInfo> getFuncInfo() {
			return funcInfo;
		}

		public void setFuncInfo(List<FuncInfo> funcInfo) {
			this.funcInfo = funcInfo;
		}

	}

	public static class FuncInfo {
		@JSONField(name = "funcscope_category")
		private FuncscopeCategory funcscopeCategory;

		public FuncscopeCategory getFuncscopeCategory() {
			return funcscopeCategory;
		}

		public void setFuncscopeCategory(FuncscopeCategory funcscopeCategory) {
			this.funcscopeCategory = funcscopeCategory;
		}

	}

	public static class FuncscopeCategory {
		@JSONField(name = "id")
		private Integer id;

		private String categoryName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
			this.categoryName = CategoryName.getDesc(id);
		}

		public String getCategoryName() {
			return categoryName;
		}

	}

	/**
	 * 授权权限说明
	 * 
	 * @ClassName: CategoryName
	 * @author Tluo
	 * @date 2017年10月18日
	 *
	 */
	public enum CategoryName {
		/**/C1(1, "消息管理权限"),
		/**/C2(2, "用户管理权限"),
		/**/C3(3, "帐号服务权限"),
		/**/C4(4, "网页服务权限"),
		/**/C5(5, "微信小店权限"),
		/**/C6(6, "微信多客服权限"),
		/**/C7(7, "群发与通知权限"),
		/**/C8(8, "微信卡券权限"),
		/**/C9(9, "微信扫一扫权限"),
		/**/C10(10, "微信连WIFI权限。"),
		/**/C11(11, "素材管理权限"),
		/**/C12(12, "微信摇周边权限"),
		/**/C13(13, "微信门店权限"),
		/**/C14(14, "微信支付权限"),
		/**/C15(15, "自定义菜单权限"),
		/**/C16(16, "获取认证状态及信息"),
		/**/C17(17, "帐号管理权限（小程序）"),
		/**/C18(18, "开发管理与数据分析权限（小程序）"),
		/**/C19(19, "客服消息管理权限（小程序）"),
		/**/C20(20, "微信登录权限（小程序）"),
		/**/C21(21, "数据分析权限（小程序）。"),
		/**/C22(22, "城市服务接口权限"),
		/**/C23(23, "广告管理权限"),
		/**/C24(24, "开放平台帐号管理权限"),
		/**/C25(25, "开放平台帐号管理权限（小程序）"),
		/**/C26(26, "微信电子发票权限");
		private int id;
		private String name;

		private CategoryName(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public static String getDesc(int id) {
			String desc = "未知权限集";
			for (CategoryName categoryName : CategoryName.values()) {
				if (id == categoryName.getId()) {
					desc = categoryName.getName();
					break;
				}
			}
			return desc;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

	}

}
