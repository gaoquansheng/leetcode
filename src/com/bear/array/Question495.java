package com.bear.array;

/**
 * 提莫攻击
 */
public class Question495 {

    /**
     *
     * @param timeSeries 攻击时刻
     * @param duration 持续时间
     * @return 中毒总时间
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int last = -1;// 记录上一次攻击的结束点
        for (int timeSery : timeSeries) {
            // 每次判断上次攻击是否重合
            int end = timeSery+duration-1;
            res += last < timeSery?duration:end-last;
            last = end;// 每次都更新
        }
        return res;
    }
    }
