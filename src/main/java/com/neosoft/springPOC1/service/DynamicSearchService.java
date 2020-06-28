package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.model.UserMaster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DynamicSearchService {

    /**
     * this method is for dynamic searching
     * pass string in URL like "fieldName1=value1&fieldName2=value2"
     * @param query
     * @return List<UserMaster>
     */
    List<UserMaster> dynamicSearch(String query);

}
