package org.slipover.frame.share.page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 游标分页
 * @param <T>
 */
public class VernierPage<T> extends PageData<T> {

    private boolean hasNext;

    public VernierPage() {
        this(new Pageable(), null, false);
    }

    public VernierPage(Pageable pageable, List<T> data, boolean hasNext) {
        super(pageable, data);
        this.hasNext = hasNext;
    }

    public boolean hasNext(){
        return hasNext;
    }

    public <R> VernierPage<R> map(Function<T, R> transition) {
        return new VernierPage<>(this, stream().map(transition).collect(Collectors.toList()), hasNext);
    }

}
