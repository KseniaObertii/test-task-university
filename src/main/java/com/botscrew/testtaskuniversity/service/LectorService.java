package com.botscrew.testtaskuniversity.service;

import com.botscrew.testtaskuniversity.dao.LectorDao;
import com.botscrew.testtaskuniversity.model.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    LectorDao lectorDao;

    @Autowired
    public LectorService(LectorDao lectorDao) {
        this.lectorDao = lectorDao;
    }

    public List<Lector> findLectorsByNameOrSurnameContaining(String nameOrSurnamePart) {
        return lectorDao.findLectorsByNameOrSurnameContaining(nameOrSurnamePart);
    }
}
