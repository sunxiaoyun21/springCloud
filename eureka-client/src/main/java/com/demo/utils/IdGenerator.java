package com.demo.utils;

/**
 * Twitter_Snowflake<br>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 */


/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/10/23 13:47
 **/
public class IdGenerator {


/**
 * SnowFlake算法 64位Long类型生成唯一ID 第一位0，表明正数 2-42，41位，表示毫秒时间戳差值，起始值自定义
 * 43-52，10位，机器编号，5位数据中心编号，5位进程编号 53-64，12位，毫秒内计数器 本机内存生成，性能高
 *
 * 主要就是三部分： 时间戳，进程id，序列号 时间戳41，id10位，序列号12位
**/
    //开始时间戳
    private final static long beginTs = 1483200000000L;

    private long lastTs = 0L;
    //进程编号
    private long processId;
    private int processIdBits = 10;

    //序列号
    private long sequence = 0L;
    private int sequenceBits = 12;


    // 10位进程ID标识
    public IdGenerator(long processId) {
        if (processId > ((1 << processIdBits) - 1)) {//processId<1023
            throw new RuntimeException("进程ID超出范围，设置位数" + processIdBits + "，最大"
                + ((1 << processIdBits) - 1));
        }
        this.processId = processId;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public synchronized   long nextId() {
        long ts = timeGen();
        if (ts < lastTs) {// 刚刚生成的时间戳比上次的时间戳还小，出错
            throw new RuntimeException("时间戳顺序错误");
        }
        if (ts == lastTs) {// 刚刚生成的时间戳跟上次的时间戳一样，则需要生成一个sequence序列号
            // sequence循环自增
            sequence = (sequence + 1) & ((1 << sequenceBits) - 1);
            // 如果sequence=0则需要重新生成时间戳
            if (sequence == 0) {
                // 且必须保证时间戳序列往后
                ts = nextTs(lastTs);
            }
        } else {// 如果ts>lastTs，时间戳序列已经不同了，此时可以不必生成sequence了，直接取0
            sequence = 0L;
        }
        lastTs = ts;// 更新lastTs时间戳
        return ((ts - beginTs) << (processIdBits + sequenceBits)) | (processId << sequenceBits)
            | sequence;
    }

    protected long nextTs(long lastTs) {
        long ts = timeGen();
        while (ts <= lastTs) {
            ts = timeGen();
        }
        return ts;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        IdGenerator ig = new IdGenerator(1);
        System.out.println(ig.nextId());
        //System.out.println(14>>>2);
        //System.out.println(2^12);
        //System.out.println(Integer.toBinaryString(-14));
        //System.out.println(Integer.toBinaryString(-8));
        System.out.println((1 << 10) );
        System.out.println((10 >>3) );

    }

}
