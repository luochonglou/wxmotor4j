package org.wxmotor4j.mp.user;

import java.util.ArrayList;
import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信用户列表拉取对象
 * 
 * @ClassName: WxMpUserPull
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpUserPull extends WxMpResponse{
	/* 关注该公众账号的总用户数 */
	@JSONField(name = "total")
	private Integer total;

	/* 拉取的OPENID个数，最大值为10000 */
	@JSONField(name = "count")
	private Integer count;

	/* 列表数据，OPENID的列表 */
	@JSONField(name = "data")
	private pullData data;

	/* 拉取列表的最后一个用户的OPENID */
	@JSONField(name = "next_openid")
	private String nextOpenid;

	public List<String> getOpenids() {
		if (null == data) {
			return new ArrayList<String>();
		}
		return this.data.getOpenid();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public pullData getData() {
		return data;
	}

	public void setData(pullData data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

	public class pullData {
		/* openid列表 */
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
