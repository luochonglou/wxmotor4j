package org.wxmotor4j.third.token.aflorist;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 一份计划表
 * 
 * @ClassName: ASchedule
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class ASchedule {
	/*
	 * 工作间隔
	 */
	private Long restTime;
	/*
	 * 工作安排
	 */
	private PriorityBlockingQueue<AFlower> jobQueue;

	public Long getRestTime() {
		return restTime;
	}

	public void setRestTime(Long restTime) {
		this.restTime = restTime;
	}

	public PriorityBlockingQueue<AFlower> getJobQueue() {
		return jobQueue;
	}

	public void setJobQueue(PriorityBlockingQueue<AFlower> jobQueue) {
		this.jobQueue = jobQueue;
	}

}
