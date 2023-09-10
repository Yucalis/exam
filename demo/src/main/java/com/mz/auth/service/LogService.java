package com.mz.auth.service;

import com.mz.auth.query.LogQuery;
import com.mz.auth.util.PageList;

public interface LogService {

    PageList listpage(LogQuery logQuery);

}
