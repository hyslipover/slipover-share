package org.slipover.frame.share.page;

import org.slipover.frame.share.config.ShareConfig;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分页数据
 * @param <T>
 */
public class PageData<T> extends Pageable {

    private int startParallelStream = ShareConfig.START_PARALLEL_STREAM;

    protected List<T> data;

    public PageData(Pageable pageable, List<T> data) {
        init(pageable);
        setData(data);
    }

    public List<T> getData() {
        return data;
    }

    public T getData(int index) {
        return index < data.size() ? data.get(index) : null;
    }

    public void setData(List<T> data) {
        this.data = data != null ? data : Collections.emptyList();
    }

    public boolean hasData(){
        return data.size() > 0;
    }

    public int size() {
        return data.size();
    }

    public T first() {
        return hasData() ? data.get(0) : null;
    }

    public T last(){
        return hasData() ? data.get(data.size() - 1) : null;
    }

    public List<T> sort(Comparator<T> comparator) {
        return stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<T> limit(int index, int size) {
        int lastIndex = index + size;
        return data.subList(index, lastIndex < data.size() ? lastIndex : data.size() - 1);
    }

    public List<T> filter(Predicate<? super T> predicate) {
        return stream().filter(predicate).collect(Collectors.toList());
    }

    public void forEach(Consumer<T> consumer){
        stream().forEach(consumer);
    }

    public void setStartParallelStream(int startParallelStream){
        this.startParallelStream = Math.abs(startParallelStream);
    }

    protected Stream<T> stream(){
        if (data.size() >= startParallelStream) {
            return data.parallelStream();
        }
        return data.stream();
    }

}
