package com.shopping.util;

public class SnowFlake {
	private static final SnowFlakeIdWorker SFIW = new SnowFlakeIdWorker(1, 1);

	public static Long getId() {
		return SFIW.nextId();
	}
}

//ѩ���㷨
class SnowFlakeIdWorker {

	// ==============================Fields===========================================
	/** ��ʼʱ��� (2015-01-01) */
	private final long twepoch = 1489111610226L;

	/** ����id��ռ��λ�� */
	private final long workerIdBits = 5L;

	/** ���ݱ�ʶid��ռ��λ�� */
	private final long dataCenterIdBits = 5L;

	/** ֧�ֵ�������id�������31 (�����λ�㷨���Ժܿ�ļ������λ�����������ܱ�ʾ�����ʮ������) */
	private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

	/** ֧�ֵ�������ݱ�ʶid�������31 */
	private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

	/** ������id��ռ��λ�� */
	private final long sequenceBits = 12L;

	/** ����ID������12λ */
	private final long workerIdShift = sequenceBits;

	/** ���ݱ�ʶid������17λ(12+5) */
	private final long dataCenterIdShift = sequenceBits + workerIdBits;

	/** ʱ���������22λ(5+5+12) */
	private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

	/** �������е����룬����Ϊ4095 (0b111111111111=0xfff=4095) */
	private final long sequenceMask = -1L ^ (-1L << sequenceBits);

	/** ��������ID(0~31) */
	private long workerId;

	/** ��������ID(0~31) */
	private long dataCenterId;

	/** ����������(0~4095) */
	private long sequence = 0L;

	/** �ϴ�����ID��ʱ��� */
	private long lastTimestamp = -1L;

	// ==============================Constructors=====================================
	/**
	 * ���캯��
	 * 
	 * @param workerId
	 *            ����ID (0~31)
	 * @param dataCenterId
	 *            ��������ID (0~31)
	 */
	public SnowFlakeIdWorker(long workerId, long dataCenterId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("workerId can't be greater than %d or less than 0", maxWorkerId));
		}
		if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
			throw new IllegalArgumentException(
					String.format("dataCenterId can't be greater than %d or less than 0", maxDataCenterId));
		}
		this.workerId = workerId;
		this.dataCenterId = dataCenterId;
	}

	// ==============================Methods==========================================
	/**
	 * �����һ��ID (�÷������̰߳�ȫ��)
	 * 
	 * @return SnowflakeId
	 */
	public synchronized long nextId() {
		long timestamp = timeGen();

		// �����ǰʱ��С����һ��ID���ɵ�ʱ�����˵��ϵͳʱ�ӻ��˹����ʱ��Ӧ���׳��쳣
		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		// �����ͬһʱ�����ɵģ�����к���������
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			// �������������
			if (sequence == 0) {
				// ��������һ������,����µ�ʱ���
				timestamp = tilNextMillis(lastTimestamp);
			}
		}
		// ʱ����ı䣬��������������
		else {
			sequence = 0L;
		}

		// �ϴ�����ID��ʱ���
		lastTimestamp = timestamp;

		// ��λ��ͨ��������ƴ��һ�����64λ��ID
		return ((timestamp - twepoch) << timestampLeftShift) //
				| (dataCenterId << dataCenterIdShift) //
				| (workerId << workerIdShift) //
				| sequence;
	}

	/**
	 * ��������һ�����룬ֱ������µ�ʱ���
	 * 
	 * @param lastTimestamp
	 *            �ϴ�����ID��ʱ���
	 * @return ��ǰʱ���
	 */
	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	/**
	 * �����Ժ���Ϊ��λ�ĵ�ǰʱ��
	 * 
	 * @return ��ǰʱ��(����)
	 */
	protected long timeGen() {
		return System.currentTimeMillis();
	}
}