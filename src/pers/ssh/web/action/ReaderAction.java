package pers.ssh.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pers.ssh.domain.Reader;
import pers.ssh.service.ReaderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReaderAction extends ActionSupport implements ModelDriven<Reader> {
    static Integer id=null;
    private ReaderService readerService;
    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }

    private Reader reader=new Reader();
    @Override
    public Reader getModel() {
        return reader;
    }
    public String queryAllReader(){
        List<Reader> list=readerService.queryAllReader(reader);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("allReader",list);
        return "allReader";
    }
    public String deleteReader(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String s=request.getParameter("deleteID");
        readerService.deleteReader(Integer.parseInt(s));
        return "allReaderAction";
    }
    public String addReader(){
        if(readerService.addReader(reader)){
            return "allReaderAction";
        }
        return null;
    }
    public String qbcReader(){
        List<Reader> list=readerService.qbcReader(reader);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("allReader",list);
        return "allReader";
    }
    public String updateReader(){
        //先调用查询方法 向list中添加数据
        List<Reader> list=readerService.qbcReader(reader);
        HttpServletRequest request1 = ServletActionContext.getRequest();
        request1.setAttribute("allReader",list);
        HttpServletRequest request = ServletActionContext.getRequest();
        id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("readername",request.getParameter("readername"));
        request.setAttribute("readertype",request.getParameter("readertype"));
        request.setAttribute("sex",request.getParameter("sex"));
        request.setAttribute("tel",request.getParameter("tel"));
        request.setAttribute("max_num",request.getParameter("max_num"));
        request.setAttribute("days_num",request.getParameter("days_num"));
        return "allReader";
    }
    public String replaceReader(){
        reader.setId(id);
        if (readerService.replaceReader(reader)){
            //先调用查询方法 向list中添加数据
            List<Reader> list=readerService.qbcReader(reader);
            HttpServletRequest request1 = ServletActionContext.getRequest();
            request1.setAttribute("allReader",list);
            return queryAllReader();
        }
        return null;
    }

}
