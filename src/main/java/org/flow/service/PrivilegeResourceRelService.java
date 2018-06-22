package org.flow.service;

import org.flow.vo.PriRes;

import java.util.List;
import java.util.Map;

public interface PrivilegeResourceRelService {


    List<PriRes> findRelPager(Map params);
    int findWhereTotal(Map params);
}
