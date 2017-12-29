package org.wxmotor4j.third.token.aflorist;

/**
 * 一个花农
 * 
 * @ClassName: AFlorist
 * @author Tluo
 * @date 2017年9月23日
 *
 */
public class AFlorist {

	private ASchedule aSchedule;

	/**
	 * 
	 * 创建一个新的实例 Florist.
	 * 
	 * @param restTime
	 *            做完一个工作休息一会~(单位:毫秒)
	 */
	public AFlorist(ASchedule aSchedule) {
		this.aSchedule = aSchedule;
	}

	/**
	 * 添加修剪对象
	 * 
	 * @Title: addPruneObject
	 * @return void 返回类型
	 */
	public void addPruneObject(AFlower flower) {
		aSchedule.getJobQueue().put(flower);
	}

	/**
	 * 根据状态开始工作
	 * 
	 * @Title: startJob
	 * @return void 返回类型
	 * @param status
	 *            工作状态(true正常工作，false罢工)
	 */
	public void startJob(boolean status) {
		while (status) {
			try {
				AFlower flower = aSchedule.getJobQueue().take();
				long nextPruneTime = flower.nextPruneTime;
				long nowTime = System.currentTimeMillis();
				if (nextPruneTime > nowTime) {
					sitBack(nextPruneTime - nowTime);
				}
				flower.prune();
				scheduleTask(flower);
				sitBack();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 安排下次工作任务
	 * 
	 * @Title: scheduleTask
	 * @return void 返回类型
	 */
	private void scheduleTask(AFlower flower) {
		flower.setNextPruneTime();
		aSchedule.getJobQueue().put(flower);
	}

	/**
	 * 休息一下
	 * 
	 * @Title: sitBack
	 * @return void 返回类型
	 */
	private void sitBack() {
		Long sleeptime = aSchedule.getRestTime();
		if (null == sleeptime) {
			sleeptime = 1000l;
		}
		sitBack(sleeptime);
	}

	/**
	 * 休息一下
	 * 
	 * @Title: sitBack
	 * @return void 返回类型
	 */
	private void sitBack(Long sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			throw new AFloristException("抠门老板不让休息 (*+﹏+*)~");
		}
	}

}
