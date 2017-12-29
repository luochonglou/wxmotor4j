package org.wxmotor4j.third.token.aflorist;

/**
 * 一朵小花
 * 
 * @ClassName: AFlower
 * @author Tluo
 * @date 2017年9月23日
 *
 */
public abstract class AFlower implements Comparable<Object> {
	/**
	 * 下次修剪时间(时间戳)
	 */
	protected long nextPruneTime;

	/**
	 * 设置下次修剪时间(时间戳)
	 * 
	 * @Title: setNextPruneTime
	 * @return void 返回类型
	 */
	public abstract void setNextPruneTime();

	/**
	 * 开始修剪
	 * 
	 * @Title: prune
	 * @return void 返回类型
	 */
	public abstract void prune();

	/**
	 * <ul>
	 * 比较方法实现
	 * <li>1、比较两个对象的下次修剪时间</li>
	 * </ul>
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof AFlower)) {
			throw new AFloristException("type mismatch, no comparison.");
		}
		AFlower f = (AFlower) o;
		if (this.nextPruneTime < f.nextPruneTime) {
			return -1;
		}
		if (this.nextPruneTime > f.nextPruneTime) {
			return 1;
		}
		return 0;
	}

}
