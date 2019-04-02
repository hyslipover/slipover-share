package org.slipover.frame.share.page;

import org.slipover.frame.share.config.ShareConfig;

import java.io.Serializable;

/**
 * 分页基本信息
 */
public class Pageable implements Serializable {

    private int pageIndex = ShareConfig.DEFAULT_PAGE_INDEX;

    private int pageSize = ShareConfig.DEFAULT_PAGE_SIZE;

    public Pageable() {
    }

    public Pageable(int pageIndex, int pageSize) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 0) {
            pageIndex = ShareConfig.DEFAULT_PAGE_INDEX;
        }
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 0) {
            pageSize = ShareConfig.DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize > ShareConfig.MAX_PAGE_SIZE ? ShareConfig.MAX_PAGE_SIZE : pageSize;
    }

    public void init(int pageIndex, int pageSize) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
    }

    public void init(Pageable pageable) {
        init(pageable.pageIndex, pageable.pageSize);
    }

}
