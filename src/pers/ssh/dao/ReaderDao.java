package pers.ssh.dao;

import pers.ssh.domain.Reader;

import java.util.List;

public interface ReaderDao {
    public List queryAllReader(Reader reader);
    public List qbcReader(Reader reader);
    public boolean deleteReader(Integer id);
    public boolean addReader(Reader reader);
    public boolean replaceReader(Reader reader);
}
