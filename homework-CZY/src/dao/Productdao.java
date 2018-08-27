package dao;

import entity.Product;

import java.util.*;

public class Productdao {
    private static List<Product> ps=new ArrayList<>();
    static {
        ps.add(new Product(1,"HTC One X","暂无备注",3000));
        ps.add(new Product(2,"Apple4s","1280×800像素，采用IOS4.0系统智能机",3900));
        ps.add(new Product(3,"联想G470AH-IFI(R)","第二代智能英特尔 酷睿2i5 处理器i5-2450M(2.5GHz,可睿频加速至3.1GHz)",2500));
        ps.add(new Product(4,"IPad3","屏幕分辨率为2560×1920",3900));
    }
    public List<Product> getAllProducts(){
        return ps;
    }
    public Product findById(int Id) {
        return ps.get(Id);
    }
    public boolean del(int Id){
        ps.remove(Id);
        if(ps.get(Id)==null){
            return true;
        }
        return false;
    }
    public boolean add(Product p){
        ps.add(p.getId(),p);
        if(ps.get(p.getId())==null){
            return true;
        }
        return false;
    }
    public boolean update(Product p){
        for (int i = 0; i < ps.size(); i++) {
            if (ps.get(i).getId() == p.getId()) {
                ps.set(i, p);
                return true;
            }
        }
        return false;
    }
}
