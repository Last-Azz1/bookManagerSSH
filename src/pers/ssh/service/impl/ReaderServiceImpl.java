package pers.ssh.service.impl;

import pers.ssh.dao.ReaderDao;
import pers.ssh.domain.Reader;
import pers.ssh.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ReaderDao readerDao;

    public void setReaderDao(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    @Override
    public List queryAllReader(Reader reader) {
        return readerDao.queryAllReader(reader);
    }

    @Override
    public boolean deleteReader(Integer id) {
        return readerDao.deleteReader(id);
    }

    @Override
    public boolean addReader(Reader reader) {
        return readerDao.addReader(reader);
    }

    @Override
    public boolean replaceReader(Reader reader) {
        return readerDao.replaceReader(reader);
    }

    @Override
    public List qbcReader(Reader reader) {
        return readerDao.qbcReader(reader);
    }

}
