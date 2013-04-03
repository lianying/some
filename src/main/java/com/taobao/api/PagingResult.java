package com.taobao.api;

import java.util.Collections;
import java.util.List;

/**
 * 表示多页的结果
 * @author Simon Leung
 * 
 */
public class PagingResult<T> {
	private List<T> data;

	private boolean hasNextPage;

	public PagingResult(List<T> data, long pageSize, long pageNo, long total) {
		this(data, (pageSize * pageNo) < total);
	}

	public PagingResult(List<T> data, boolean hasNextPage) {
		this.data = data;
		this.hasNextPage = hasNextPage;
	}

	public boolean hasNextPage() {
		return hasNextPage;
	}

	public List<T> getData() {
	    if(data != null) {
	        return data;
	    }
		return Collections.emptyList();
	}
}
