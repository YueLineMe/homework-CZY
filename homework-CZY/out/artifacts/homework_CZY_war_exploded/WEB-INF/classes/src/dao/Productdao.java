package dao;

import entity.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Productdao {
    private static Map<String, Product> ps=new HashMap<String,Product>();
    static {
        ps.put("001",new Product("001","HTC One X","暂无备注",3000));
                ps.put("002",new Product("002","Apple4s","1280×800像素，采用IOS4.0系统智能机",3900));
        ps.put("003",new Product("003","联想G470AH-IFI(R)","第二代智能英特尔 酷睿2i5 处理器i5-2450M(2.5GHz,可睿频加速至3.1GHz)",2500));
        ps.put("004",new Product("004","IPad3","屏幕分辨率为2560×1920",3900));
    }
    public Collection<Product> getAllProducts(){
        return ps.values();
    }
    public Product findById(String Id) {
        return ps.get(Id);
    }
    public boolean del(String Id){
        ps.remove(Id);
        if(ps.get(Id)==null){
            return true;
        }
        return false;
    }
    public boolean add(Product p){
        ps.put(p.getId(),p);
        if(ps.get(p.getId())==null){
            return true;
        }
        return false;
    }
    public boolean update(Product p){
        ps.put(p.getId(),p);
        if(ps.get(p.getId())==null){
            return true;
        }
        return false;
    }
}
