package org.nobleprog.camel.component.jdbc.route;


import org.nobleprog.camel.component.jdbc.model.TradeOrder;

public class OrderToSqlBean {

    private static int id = 2;

    public String createOrderSql(TradeOrder tradeOrder){
        String sql = "INSERT INTO TRADE VALUES("+
                id++ +",'"
                +tradeOrder.getOrderId()+"',"
                +tradeOrder.getQuantity()+",'"
                +tradeOrder.getBuySell()+"',"
                +"to_date('"+tradeOrder.getDate()+"','DD-MON-RR'))";
        return sql;
    }
    public String selectOrderSql(String id){
        String sql = "select * from trade where id = "+id;
        return sql;
    }
}
