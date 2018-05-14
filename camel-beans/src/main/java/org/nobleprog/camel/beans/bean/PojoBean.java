package org.nobleprog.camel.beans.bean;


public class PojoBean {

    /*
        Since this is the only method with 1 parameter, it will be chosen by camel
     */

    public String invoke(String body){
        return body + " from pojo";
    }
}
