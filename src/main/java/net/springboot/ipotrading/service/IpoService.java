package net.springboot.ipotrading.service;
import net.springboot.ipotrading.model.Ipo;
import java.util.List;
public interface IpoService {

    void save(Ipo ipo);
    List<Ipo> findAll();
    List<Ipo> findIpoByUserName(String userName);

}
