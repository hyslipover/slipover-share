package org.slipover.frame.share.config;

import java.io.Serializable;

public final class ShareConfig implements Serializable {

    /**
     * 默认初始页码
     */
    public static int DEFAULT_PAGE_INDEX = 1;
    /**
     * 默认每页数据量
     */
    public static int DEFAULT_PAGE_SIZE = 20;
    /**
     * 最大每页数据量
     */
    public static int MAX_PAGE_SIZE = 200;
    /**
     * 启动并行处理的节点
     */
    public static int START_PARALLEL_STREAM = 50;

}
