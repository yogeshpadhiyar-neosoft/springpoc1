package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.Constant.AppMessages;
import com.neosoft.springPOC1.exception.CustomMessage;
import com.neosoft.springPOC1.model.UserMaster;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@Service
public class DynamicSearchCustomImpl implements DynamicSearchService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserMaster> dynamicSearch(String query) throws CustomMessage{
        if(query==null)
            throw new CustomMessage(HttpStatus.BAD_REQUEST, Arrays.asList(AppMessages.WRONG_QUERY));
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserMaster> criteriaQuery = criteriaBuilder.createQuery(UserMaster.class);
        Root<UserMaster> userMaster = criteriaQuery.from(UserMaster.class);
        criteriaQuery.select(userMaster);
        TypedQuery<UserMaster> queryResult = entityManager.createQuery(query,UserMaster.class);

        if(queryResult.getResultList().isEmpty())
            throw new CustomMessage(HttpStatus.BAD_REQUEST, Arrays.asList(AppMessages.WRONG_QUERY));
        else
            return queryResult.getResultList();
    }

}
