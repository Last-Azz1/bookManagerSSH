package pers.ssh.service;

import pers.ssh.domain.Reader;

import java.util.List;

public interface ReaderService {
    public List queryAllReader(Reader reader);
    public List qbcReader(Reader reader);
    public boolean deleteReader(Integer id);
    public boolean addReader(Reader reader);
    public boolean replaceReader(Reader reader);
}
