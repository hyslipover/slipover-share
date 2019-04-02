package org.slipover.frame.share.page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页对象
 * @param <T>
 */
public class Page<T> extends PageData<T> {

    private int totalCount;

    private int totalPage;

    public Page(final Pageable pageable, List<T> data, int totalCount) {
        super(pageable, data);
        setTotalCount(totalCount);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = Math.abs(totalCount);
        totalPage = this.totalCount / getPageSize() + (this.totalCount % getPageSize() > 0 ? 1 : 0);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public <R> Page<R> map(final Function<T, R> transition) {
        return new Page<>(this, stream().map(transition).collect(Collectors.toList()), totalCount);
    }

}
