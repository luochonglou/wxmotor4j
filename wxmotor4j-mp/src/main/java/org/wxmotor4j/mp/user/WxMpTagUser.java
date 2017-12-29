package org.wxmotor4j.mp.user;

import java.util.ArrayList;
import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信标签用户对象
 * 
 * @ClassName: WxMpTagUsers
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpTagUser extends WxMpResponse {
	@JSONField(name = "count")
	private Integer count;
	@JSONField(name = "data")
	private ResData data;
	@JSONField(name = "next_openid")
	private String nextOpenid;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ResData getData() {
		return data;
	}

	public void setData(ResData data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

	public List<String> getOpenids() {
		if (null == this.data) {
			return new ArrayList<String>();
		}
		return this.data.getOpenid();
	}

	public class ResData {
		@JSONField(name = "openid")
		List<String> openid;

		public List<String> getOpenid() {
			return openid;
		}

		public void setOpenid(List<String> openid) {
			this.openid = openid;
		}

	}
}
